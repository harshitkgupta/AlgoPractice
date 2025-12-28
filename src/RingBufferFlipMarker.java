
public class RingBufferFlipMarker {
  private int capacity = 0;
  private int readPos = 0;
  private int writePos = 0;
  boolean flipMarker = false;
  private Object[] elements = null;

  public RingBufferFlipMarker(int capacity) {
    this.capacity = capacity;
  }

  public int getCapacity() {
    return this.capacity;
  }

  public int getFilled() {
    if (!flipMarker) {
      return writePos - readPos;
    }
    return capacity - readPos + writePos;
  }

  public int getRemaining() {
    if (!flipMarker) {
      return capacity - writePos;
    }
    return readPos - writePos;
  }

  public boolean put(Object element) {
    if (writePos >= capacity) {
      writePos = 0;
      flipMarker = true;
    }
    if (getRemaining() > 0) {

      elements[writePos] = element;
      writePos++;
      return true;
    }
    return false;
  }

  public Object take() {
    if (readPos >= capacity) {
      readPos = 0;
      flipMarker = false;
    }
    if (getFilled() > 0) {

      Object readObj = elements[readPos];
      readPos++;
      return readObj;
    }
    return null;
  }
}
