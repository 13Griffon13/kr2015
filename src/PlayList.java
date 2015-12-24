import java.io.*;
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
            playlist.add(directoryName+tmp[i]);
        }
    }

    public LinkedList<String> getList(){
        return playlist;
    }

    public String getNext(){
        num++;
        return playlist.get(num);
    }

    public String getPrev(){
        num--;
        return playlist.get(num);
    }

    public String getByNumber(int num){
        return playlist.get(num);
    }

    public void swap(int p1,int p2){
        String s=playlist.get(p1);
        playlist.set(p1,playlist.get(p2));
        playlist.set(p2,s);
    }

    public void saveList(String name) throws IOException {
        File list = new File(name+".list");
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(list));
        oos.write(playlist.toString().getBytes());
    }

    public void loadList(String name) throws IOException, ClassNotFoundException {
        File file = new File(name+".list");
        ObjectInputStream ois=new ObjectInputStream(new FileInputStream(file));
        playlist=(LinkedList<String>)ois.readObject();

    }

    public void delSong(int num){
        playlist.remove(num);
    }

    public void addSong(String file){
        if(!new File(file).isDirectory()){
            if(file.endsWith(".wav")){
                playlist.addLast(file);
            }
        } else{
            String [] dir=new File(file).list();
            for(int i=0;i<dir.length;i++){
                if(!new File(file+'/'+dir[i]).isDirectory()){
                    if(dir[i].endsWith(".wav")){
                        playlist.addLast(file+'/'+dir[i]);
                    }
                }else {
                    addSong(file+'/'+dir[i]);
                }
            }
        }
    }
}
