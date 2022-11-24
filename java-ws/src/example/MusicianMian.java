package example;


import example.model.MusicalActivityPo;
import example.service.MusicianService;
import example.service.impl.MusicianServiceImpl;
import javax.xml.ws.Endpoint;


public class MusicianMian {

    public static void main(String[] arg) {
        MusicianService     musicianService  = new MusicianServiceImpl();
        musicianService.initMusicalActivity(new MusicalActivityPo(1,"China","周杰论","发布专辑"));
        musicianService.initMusicalActivity(new MusicalActivityPo(2,"Hong Kong","林俊杰","巡回演出"));
        System.out.println("webService服务正在启动");
        String serverIp = "127.0.0.1";
        String serverPort = "8086";
        String musicianServiceUrl = "http://"+serverIp+":"+serverPort+"/MusicianService";
        Endpoint.publish(musicianServiceUrl, musicianService);
        System.out.println("musicianeService发布地址：" + musicianServiceUrl);
        System.out.println("webService服务启动成功");
    }
}
