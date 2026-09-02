class MyHashSet {
    private boolean[] main;

    public MyHashSet() {
        main = new boolean[1000001];
        Arrays.fill(main, false);
    }
    
    public void add(int key) {
        main[key] = true;
    }
    
    public void remove(int key) {
        main[key] = false;
    }
    
    public boolean contains(int key) {
        return main[key];
    }
}
