package pl.qualityexcites.workshop.stdbp.domain;

/**
 * Created by mlo on 05.07.2017.
 */
public enum Category {
    DRESSES(8);

    private final int categoryNumber;

    Category(int categoryNumber) {
        this.categoryNumber = categoryNumber;
    }

    public int getCategoryNumber() {
        return categoryNumber;
    }
}
