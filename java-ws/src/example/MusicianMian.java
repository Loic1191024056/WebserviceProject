package example;


import example.model.MusicalActivityPo;
import example.service.MusicianService;
import example.service.impl.MusicianServiceImpl;
import javax.xml.ws.Endpoint;


public class MusicianMian {

    public static void main(String[] arg) {
        MusicianService     musicianService  = new MusicianServiceImpl();
        musicianService.initMusicalActivity(new MusicalActivityPo(1,"China","Jay Chou","Release an album"));
        musicianService.initMusicalActivity(new MusicalActivityPo(2,"Hong Kong","Lin","Performing in Hong Kong"));
        System.out.println("webService the server is starting");
        String serverIp = "127.0.0.1";
        String serverPort = "8086";
        String musicianServiceUrl = "http://"+serverIp+":"+serverPort+"/MusicianService";
        Endpoint.publish(musicianServiceUrl, musicianService);
        System.out.println("musicianeService Publishing Address：" + musicianServiceUrl);
        System.out.println("webService Service startup succeeded");
    }
}
