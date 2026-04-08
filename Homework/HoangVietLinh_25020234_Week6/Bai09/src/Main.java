public class Main {
    public static void main(String[] args) {
        AudioPlayer audioPlayer = new AudioPlayer();
        VideoPlayer videoPlayer = new VideoPlayer();
        MediaPlayer mediaPlayer = new MediaPlayer(audioPlayer, videoPlayer);
        mediaPlayer.playAudio("audio.mp3");
        mediaPlayer.playVideo("video.mp4");
    }
}
