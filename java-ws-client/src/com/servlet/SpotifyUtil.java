package com.servlet;


import com.wrapper.spotify.SpotifyApi;

/**
 *
 * @since Created at 2022-11-22 15:17
 */
public class SpotifyUtil {

   public static SpotifyApi getSpotifyApi(){

      SpotifyApi spotifyApi =  new SpotifyApi.Builder()
              .setClientId("e1c9aaa6375e42d28742ea3172108a08")
              .setClientSecret("c5453b53a1d14904b8a42ce90d90ded3")
              .build();
      return spotifyApi;
   }


}
