package com.servlet;

import com.wrapper.spotify.SpotifyApi;
import com.wrapper.spotify.model_objects.credentials.ClientCredentials;
import com.wrapper.spotify.model_objects.specification.Artist;
import com.wrapper.spotify.model_objects.specification.Paging;
import com.wrapper.spotify.requests.authorization.client_credentials.ClientCredentialsRequest;
import com.wrapper.spotify.requests.data.artists.GetArtistRequest;
import com.wrapper.spotify.requests.data.search.simplified.SearchArtistsRequest;
import java.util.concurrent.CancellationException;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionException;

/**
 *
 * @since Created at 2022-11-23 10:56
 */
public class ClientCredentialsExample{
    private static final String clientId = "e1c9aaa6375e42d28742ea3172108a08";
    private static final String clientSecret = "c5453b53a1d14904b8a42ce90d90ded3";
    private static final String q = "abba";
    private static final SpotifyApi spotifyApi = new SpotifyApi.Builder()
            .setClientId(clientId)
            .setClientSecret(clientSecret)
            .build();

    private static final ClientCredentialsRequest clientCredentialsRequest = spotifyApi.clientCredentials()
            .build();


    public static void clientCredentials_Async() {
        try {
            final CompletableFuture<ClientCredentials> clientCredentialsFuture = clientCredentialsRequest.executeAsync();


            final ClientCredentials clientCredentials = clientCredentialsFuture.join();


            spotifyApi.setAccessToken(clientCredentials.getAccessToken());
            GetArtistRequest getArtistRequest = spotifyApi.getArtist("6HclTVD03WSY6GUpN16BkP").build();
            final CompletableFuture<Artist> albumFuture = getArtistRequest.executeAsync();


            final Artist artist = albumFuture.join();
            System.out.println("Name: " + artist.toString());
            System.out.println("accessToken in: " + clientCredentials.getAccessToken());
            System.out.println("Expires in: " + clientCredentials.getExpiresIn());

            //获取制定艺术家信息
            SearchArtistsRequest searchArtistsRequest = spotifyApi.searchArtists(q).build();
            CompletableFuture<Paging<Artist>> pagingFuture = searchArtistsRequest.executeAsync();

            final Paging<Artist> artistPaging = pagingFuture.join();
            artistPaging.getItems();
            System.out.println(artistPaging.toString());
            System.out.println("Total: " + artistPaging.getTotal());
        } catch (CompletionException e) {
            System.out.println("Error: " + e.getCause().getMessage());
        } catch (CancellationException e) {
            System.out.println("Async operation cancelled.");
        }
    }
    public static void main(String[] args) {
        clientCredentials_Async();
    }
}
