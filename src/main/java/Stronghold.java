import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;

import java.io.File;
import java.math.BigInteger;
import java.nio.file.Files;
import java.security.MessageDigest;
import java.util.Arrays;
import java.util.concurrent.Callable;

@Command(name = "findstronghold", mixinStandardHelpOptions = true, version = "findstronghold 1.0",
        description = "Finds the Minecraft stronghold location based on 2 ender eye throws.")
class Stronghold implements Callable<Integer> {

    @Parameters (paramLabel = "FIRST_THROW", description = "[<x_coordinates>,<y_coordinates>,<angle_from_y>]", converter = EnderEyeThrowConverter.class)
    private EnderEyeThrow firstThrow;
    @Parameters (paramLabel = "SECOND_THROW", description = "[<x_coordinates>,<y_coordinates>,<angle_from_y>]", converter = EnderEyeThrowConverter.class)
    private EnderEyeThrow secondThrow;

    @Override
    public Integer call() throws Exception { // your business logic goes here...
               System.out.println(Arrays.toString(firstThrow.getIntersectionWith(secondThrow)));
        return 0;
    }

    public static void main(String... args) {
        int exitCode = new CommandLine(new Stronghold()).execute(args);
        System.exit(exitCode);
    }
}