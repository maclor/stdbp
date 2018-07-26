package pl.qualityexcites.workshop.stdbp.helpers;

import static com.google.common.collect.Lists.newArrayList;

public enum Color {
    YELLOW("(241,196,15)", "#F1C40F"),
    BEIGE("(245,245,220)", "#F5F5DC"),
    WHITE("(255,255,255)", "#FFFFFF"),
    BLACK("(67,74,84)", "#434A54"),
    ORANGE("(243,156,17)", "#F39C11"),
    BLUE("(93,156,236)", "#5D9CEC"),
    GREEN("(160,212,104)", "#A0D468"),
    PINK("(252,202,205)", "#FCCACD");

    private final String rgb;
    private final String hex;

    Color(String rgb, String hex) {
        this.rgb = rgb;
        this.hex = hex;
    }

    public String getRgb() {
        return rgb;
    }

    public String getHex() {
        return hex;
    }

    public static Color getColorForRgb(String rgb) {
        return newArrayList(values()).stream()
                .filter(color -> color.getRgb().contains(rgb.toUpperCase()))
                .findFirst()
                .orElse(null);
    }
}
