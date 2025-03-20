# File Handling in Java

Java provides abstraction for file handling through streams. These streams are essentially sequences of data, which Java can read or write to input/output devices.

## Types of Streams in Java:
1. **Byte Stream**
    - Deals with raw byte data.
    - Suitable for handling all kinds of I/O, including binary files like images or audio.
    - Works with input and output byte data (8-bit).

2. **Character Stream**
    - Deals with data in the form of characters.
    - Suitable for text data (16-bit Unicode).
    - Handles encoding and decoding automatically.

---

## Stream Hierarchy in Java

Streams in Java are linked to input/output devices, and Java implements these through a class hierarchy in the `java.io` package.

### Types of Streams in Java:
1. **Byte Stream**
    - **InputStream**
    - **OutputStream**  
      These deal with raw byte data and are typically used for reading and writing binary data.

2. **Character Stream**
    - **Reader**
    - **Writer**  
      These deal with data in character form, often text files, and work with Unicode data.

---

## Summary:

- **Byte Stream**: Works with raw bytes (8-bit data), used for binary data like images and audio.
    - Example classes: `FileInputStream`, `FileOutputStream`

- **Character Stream**: Works with characters (16-bit Unicode data), suitable for text data.
    - Example classes: `FileReader`, `FileWriter`
