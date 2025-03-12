## Python implementation

```python
def is_even(number):
    return number % 2 == 0

# Example usage:
print(is_even(4))  # Output: True
print(is_even(7))  # Output: False
```

## JavaScript implementation

```javascript
function isEven(number) {
    return number % 2 === 0;
}

// Example usage:
console.log(isEven(4)); // Output: true
console.log(isEven(7)); // Output: false
```

## Explanation

The Python implementation uses a function named `is_even` that takes a single argument `number`. It returns `True` if the number is even (i.e., when the remainder of the division of the number by 2 is zero), otherwise, it returns `False`.

The JavaScript implementation uses a function named `isEven` that also takes a single argument `number`. It returns `true` if the number is even (using the same logic as the Python function) and `false` otherwise.

### Differences

1. **Syntax**: 
   - In Python, functions are defined using the `def` keyword, whereas in JavaScript, the `function` keyword is used.
   - Python uses `True` and `False` for boolean values, while JavaScript uses `true` and `false`.

2. **Type Coercion**:
   - JavaScript has type coercion, which can sometimes lead to unexpected results if the input is not properly handled. In contrast, Python is more strict with types.
   
3. **Function Calls**:
   - The syntax for calling functions and printing to the console/output is slightly different. Python uses `print()`, while JavaScript uses `console.log()`.
