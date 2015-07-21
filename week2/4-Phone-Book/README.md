# Phone book


Given a vector of names and phone numbers `phone_book` and another vector of
phone numbers `numbers` find the names that correspond to the phone numbers
in the second vector.

For the purpose of this task names are plain strings and numbers are integers in
the range `0..2147483648`.

```
lookup_names(phone_book, numbers) {
  ...
  return names
}
=======
Implement a function in [Java](PhoneBook.java), [Python](phone_book.py)
or [C++](phone_book.cpp) that given a vector of pairs (names and phone numbers)
and another vector of phone numbers finds the names that correspond to the phone
numbers in the second vector.

## Limits

```
1 <= N,M <= 7000
```

The phone number will be at most 9 digits and the
name will be at most 30 characters. The number and the name will not contain
white spaces.

## Example

Input:
```
4 2
1 Stanislav
15 Rado
6 Ivan
8 Ivan
15
8
```

Output:
```
=======
Rado
Ivan
