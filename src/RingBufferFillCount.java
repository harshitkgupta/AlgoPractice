
public class RingBufferFillCount {
  private int capacity = 0;
  private int writePos = 0;
  private int filled = 0;

  private Object[] elements = null;

  public RingBufferFillCount(int capacity) {
    this.capacity = capacity;
    this.elements = new Object[capacity];
  }

  public int getCapacity() {
    return this.capacity;
  }

  public int getFilled() {
    return this.filled;
  }

  public int getRemainingCapacity() {
    return this.capacity - this.filled;
  }

  public void reset() {
    this.writePos = 0;
    this.filled = 0;
  }

  public boolean put(Object element) {
    if (getRemainingCapacity() > 0) {
      if (writePos >= capacity) {
        writePos = 0;
      }
      elements[writePos] = element;
      writePos++;
      filled++;
      return true;
    }
    return false;
  }

  public int put(Object[] newElements) {
    int elemIndex = 0;
    int nLength = newElements.length;
    if (writePos > filled) {
      if (capacity - writePos >= nLength) {
        for (; elemIndex < nLength; elemIndex++, writePos++) {
          elements[writePos] = newElements[elemIndex];
        }

      } else {
        int lastFreePos = writePos - filled;
        for (; writePos < capacity; elemIndex++, writePos++) {
          elements[writePos] = newElements[elemIndex];
        }
        writePos = 0;

        for (; writePos < lastFreePos && elemIndex < nLength; elemIndex++, writePos++) {
          elements[writePos] = newElements[elemIndex];
        }
      }
    } else {
      int endPos = capacity + writePos - filled;
      for (; endPos < writePos && elemIndex < nLength; elemIndex++, writePos++) {
        elements[writePos] = newElements[elemIndex];
      }
    }

    filled += elemIndex;
    return elemIndex;
  }

  public Object take() {
    if (getFilled() == 0) {
      return null;
    }
    int readSlot = writePos - filled;
    if (readSlot < 0) {
      readSlot += capacity;
    }
    Object nextObj = elements[readSlot];
    filled--;
    return nextObj;
  }

  public int take(Object arr[]) {
    int mLength = arr.length;
    int readCount = 0;
    if (writePos > filled) {
      int readPos = writePos - filled;
      for (; readPos < writePos && readCount < mLength; readPos++, readCount++) {
        arr[readCount] = elements[readPos];
      }
    }
    filled -= readCount;
    return readCount;
  }
}
