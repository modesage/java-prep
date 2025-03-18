### StringBuffer

- **StringBuffer** is a mutable sequence of characters.
- It allows changing its content without creating a new object.

### Advantages over `String`:
- **Mutable**: You can modify its content.
- **Efficient**: No new objects are created during modifications.
- **Thread-safe**: `StringBuffer` is synchronized, ensuring thread safety, though this can make it slower compared to `StringBuilder`, which is not thread-safe but faster.
