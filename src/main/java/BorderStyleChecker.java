public class BorderStyleChecker {

    // BEFORE — uses single & (bitwise, always evaluates both sides)
    public boolean shouldApplyThickTop_before(int dy, boolean isHeader) {
        return (dy == 0 & isHeader); // bug: single &
    }

    // AFTER — uses && (logical, short-circuit)
    public boolean shouldApplyThickTop_after(int dy, boolean isHeader) {
        boolean header = isHeader;
        return (dy == 0 && header); // fix: double &&
    }
}