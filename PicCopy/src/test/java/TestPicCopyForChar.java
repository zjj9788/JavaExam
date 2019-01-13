import javax.swing.*;
import java.io.File;

public class TestPicCopyForChar {
    public static void main(String[] args) {
        PicCopyForChar picCopyForChar = null;
        JFileChooser jFileChooser = new JFileChooser();
        int i = jFileChooser.showOpenDialog(null);
        if (i == 0) {
            File selectedFile = jFileChooser.getSelectedFile();
            picCopyForChar = new PicCopyForChar(selectedFile.getAbsolutePath());
            int j = jFileChooser.showOpenDialog(null);
            if (j == 0) {
                picCopyForChar.uploadPic(jFileChooser.getSelectedFile().getParent());
            }
        //    picCopyForChar.close();
        }
    }
    public static void main1(String[] args) {
        PicCopyForStream picCopyForChar = null;
        JFileChooser jFileChooser = new JFileChooser();
        int i = jFileChooser.showOpenDialog(null);
        if (i == 0) {
            File selectedFile = jFileChooser.getSelectedFile();
            picCopyForChar = new PicCopyForStream(selectedFile.getAbsolutePath());
            int j = jFileChooser.showOpenDialog(null);
            if (j == 0) {
                picCopyForChar.uploadPic(jFileChooser.getSelectedFile().getParent());
            }
          // picCopyForChar.close();
        }
    }
}
