public class MediaPlayer {
    private final AudioPlayable audioPlayer;
    private final VideoPlayable videoPlayer;
    public MediaPlayer(AudioPlayable audioPlayer, VideoPlayable videoPlayer) {
        this.audioPlayer = audioPlayer;
        this.videoPlayer = videoPlayer;
    }
    public void playAudio(String file) {audioPlayer.playAudio(file);}
    public void playVideo(String file) {videoPlayer.playVideo(file);}
}
