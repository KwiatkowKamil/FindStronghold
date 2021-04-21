import picocli.CommandLine;

class EnderEyeThrowConverter implements CommandLine.ITypeConverter<EnderEyeThrow> {
    public EnderEyeThrow convert(String str) throws Exception {
        str = str.substring(1, str.length()-1);
        String [] strings = str.split(",");
        double [] doubles = new double [3];
        try {
            if (strings.length > 3){
                throw new IllegalArgumentException(
                        "Invalid number of array elements, must be: 3");
            }
            for (int i = 0; i<3; i++) {
                doubles[i] = Double.parseDouble(strings[i]);
            }

        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
        return new EnderEyeThrow(doubles);
    }
}