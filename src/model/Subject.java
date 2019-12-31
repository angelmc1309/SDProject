package model;

public interface Subject {
    public void attach(view.Observer o);
    public void detach(view.Observer o);
    public void _notify();
}
