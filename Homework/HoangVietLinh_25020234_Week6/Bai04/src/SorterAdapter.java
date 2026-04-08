public class SorterAdapter implements Sorter {
    private final LegacySorter legacySorter;
    public SorterAdapter() {
        this.legacySorter = new LegacySorter();
    }
    @Override
    public int[] sort(int[] arr) {
        return legacySorter.quickSort(arr);
    }
}
