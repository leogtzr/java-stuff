public class NestedAccessControl {

    private static String LEVEL = "outer";

    private static class Inner {
        private static String getOuterField() {
            return NestedAccessControl.LEVEL;
        }
    }

    public static void main(final String[] args) {
        // LEVEL.getOuterField();
        Inner.getOuterField();
    }
}