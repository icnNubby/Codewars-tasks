import java.io.IOException;

public class ByteStream {
	
  /**
   * Flip stream between write and read mode.
   * Before the first call of this method, the stream is neither in read nor write mode.
   * The first call of this method switches the stream to write mode.
   * After a switch to write mode, the stream is empty and bytes may be written.
   * After a switch to read mode, written bytes may be read.
   * @throws IOException if an I/O error occurs
   */
	
	public void flip() throws IOException {
		// TODO
	}

  /**
   * Write byte to stream.
   * @param b byte
   * @throws IOException if stream is not in write mode or an I/O error occurs
   */
	public void write(byte b) throws IOException {
		// TODO
	}

  /**
   * Read byte from stream.
   * @return -1 if stream is empty, byte value (0 to 255) otherwise
   * @throws IOException if stream is not in read mode or an I/O error occurs
   */
  public int read() throws IOException {
    // TODO
	
    return -1;
  }
}
