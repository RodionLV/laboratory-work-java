import Compressor.Compressor;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;


public class Main {
    public static void main(String[] args) throws IOException {

        Compressor.compress( new File("src/text.txt").getAbsolutePath(), new File("src/out/compressText.comp").getAbsolutePath() );

        Compressor.decompress( new File("src/out/compressText.comp").getAbsolutePath(), new File("src/out/decompressText.txt").getAbsolutePath() );

    }
}