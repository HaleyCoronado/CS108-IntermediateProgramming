public abstract class AbstractListADT<E> implements ListADT<E> {

    protected int size;

    public AbstractListADT() {
        size = 0;
    }

    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }

    @Override
    public int size() {
        return this.size;
    }

}