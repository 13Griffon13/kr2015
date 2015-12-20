import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Created by Griffon on 18.12.2015.
 */
public class PlayList {
    private LinkedList<String> playlist;
    private int num;
    private String directoryName;
    public PlayList(String directoryName){
        this.directoryName=directoryName;
        num=0;
        playlist=new LinkedList<>();
        File directory=new File(directoryName);
        String []tmp= directory.list(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                if(name.endsWith(".wav")){
                    return true;
                }else{
                    return false;
                }
            }
        });
        for(int i=0;i<tmp.length;i++){
            playlist.add(tmp[i]);
        }
    }
    public LinkedList<String> getList(){
        return playlist;
    }
    public String getNext(){
        num++;
        return directoryName+playlist.get(num);
    }
    public String getPrev(){
        num--;
        return directoryName+playlist.get(num);
    }
    public String getByNumber(int num){
        return directoryName+playlist.get(num);
    }
}
