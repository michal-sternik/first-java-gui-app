package Observable;

import Observers.Obserwator;

public interface Subject {
    public void zarejestrujOdbiorce(Obserwator o);
    public void wyrejestrujOdbiorce(Obserwator o);
    public void powiadomOZmianie();
}
