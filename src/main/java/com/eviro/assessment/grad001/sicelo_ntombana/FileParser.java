package com.eviro.assessment.grad001.sicelo_ntombana;

import java.io.File;
import java.io.IOException;
import java.net.URI;

public interface FileParser{
    void parseCSV(File csvFile) throws IOException;
    File convertCSVDataToImage(String Base64ImageData);
    URI createImageLink(File fileImage);

}
