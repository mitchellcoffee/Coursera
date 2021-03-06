function [J grad] = nnCostFunction(nn_params, ...
                                   input_layer_size, ...
                                   hidden_layer_size, ...
                                   num_labels, ...
                                   X, y, lambda)
%NNCOSTFUNCTION Implements the neural network cost function for a two layer
%neural network which performs classification
%   [J grad] = NNCOSTFUNCTON(nn_params, hidden_layer_size, num_labels, ...
%   X, y, lambda) computes the cost and gradient of the neural network. The
%   parameters for the neural network are "unrolled" into the vector
%   nn_params and need to be converted back into the weight matrices. 
% 
%   The returned parameter grad should be a "unrolled" vector of the
%   partial derivatives of the neural network.
%

% Reshape nn_params back into the parameters Theta1 and Theta2, the weight matrices
% for our 2 layer neural network
Theta1 = reshape(nn_params(1:hidden_layer_size * (input_layer_size + 1)), ...
                 hidden_layer_size, (input_layer_size + 1));

Theta2 = reshape(nn_params((1 + (hidden_layer_size * (input_layer_size + 1))):end), ...
                 num_labels, (hidden_layer_size + 1));

% Setup some useful variables
m = size(X, 1);
         
% You need to return the following variables correctly 
J = 0;
Theta1_grad = zeros(size(Theta1));
Theta2_grad = zeros(size(Theta2));

% ====================== YOUR CODE HERE ======================
% Instructions: You should complete the code by working through the
%               following parts.
%
% Part 1: Feedforward the neural network and return the cost in the
%         variable J. After implementing Part 1, you can verify that your
%         cost function computation is correct by verifying the cost
%         computed in ex4.m
%
for i = 1 : m,
    xi = X(i, :);
    xi = [1; xi'];
    hx = sigmoid(Theta1 * xi);
    hx = [1; hx];
    hx = sigmoid(Theta2 * hx);
    yiValue = y(i,:);
    yi = zeros(num_labels, 1);
    yi(yiValue, 1) = 1;
    res = sum(-yi .* log(hx) - (1 - yi) .* log(1 - hx));
    J += res;
end;
J /= m;

theta1NoBias = Theta1(:, [2:size(Theta1)(2)]);
theta2NoBias = Theta2(:, [2:size(Theta2)(2)]);
sumTheta = sum(sum(theta1NoBias .* theta1NoBias)) + sum(sum(theta2NoBias .* theta2NoBias));
J += lambda / 2 / m * sumTheta;


% Part 2: Implement the backpropagation algorithm to compute the gradients
%         Theta1_grad and Theta2_grad. You should return the partial derivatives of
%         the cost function with respect to Theta1 and Theta2 in Theta1_grad and
%         Theta2_grad, respectively. After implementing Part 2, you can check
%         that your implementation is correct by running checkNNGradients
%
%         Note: The vector y passed into the function is a vector of labels
%               containing values from 1..K. You need to map this vector into a 
%               binary vector of 1's and 0's to be used with the neural network
%               cost function.
%
%         Hint: We recommend implementing backpropagation using a for-loop
%               over the training examples if you are implementing it for the 
%               first time.
%


for i = 1 : m,
    xi = X(i, :);
    xi = [1; xi'];
    a_1 = xi;                      % a_1 = xi
    z_2 = Theta1 * a_1;            % z_1
    a_2 = sigmoid(z_2);            
    a_2 = [1; a_2];                % a_2
    z_3 = Theta2 * a_2;            % z_3
    a_3 = sigmoid(z_3);            % a_3
   
    yi = zeros(num_labels, 1);
    yivalue = y(i, :);
    yi(yivalue, 1) = 1;

    delta_3 = a_3 - yi;            % delta_3
    opa = Theta2' * delta_3;
    opa = opa(2:end);
    opb = sigmoidGradient(z_2);
    delta_2 = opa .* opb;
   
    
    Theta2_grad += delta_3 * a_2' / m;   % big_delta-2
    Theta1_grad += delta_2 * a_1' / m;

end;


% Part 3: Implement regularization with the cost function and gradients.
%
%         Hint: You can implement this around the code for
%               backpropagation. That is, you can compute the gradients for
%               the regularization separately and then add them to Theta1_grad
%               and Theta2_grad from Part 2.
%
% -------------------------------------------------------------

    Theta2_add = Theta2(:,[2:end]);
    Theta2_grad += [zeros(num_labels,1) Theta2_add] * lambda / m;

    Theta1_add = Theta1(:,[2:end]);
    Theta1_grad += [zeros(hidden_layer_size,1) Theta1_add] * lambda / m;
    
% =========================================================================

% Unroll gradients
grad = [Theta1_grad(:) ; Theta2_grad(:)];







end
