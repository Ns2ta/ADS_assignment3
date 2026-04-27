import java.util.Random;

class MyTestingClass {
    int a;
    int b;

    public MyTestingClass(int a, int b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MyTestingClass)) return false;
        MyTestingClass other = (MyTestingClass) o;
        return a == other.a && b == other.b;
    }

    @Override
    public int hashCode() {
        int hash = a;

        hash = (hash ^ (hash >>> 16)) * 0x45d9f3b;
        hash = (hash ^ (hash >>> 16)) * 0x45d9f3b;
        hash = hash ^ (hash >>> 16);

        hash += b;

        return hash;
    }
}