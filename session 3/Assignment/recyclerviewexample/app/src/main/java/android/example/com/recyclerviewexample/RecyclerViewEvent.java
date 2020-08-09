package android.example.com.recyclerviewexample;

public interface RecyclerViewEvent {
    void onRecyclerViewClick(int pos);

    void update(int pos);

    void delete(int pos);
}