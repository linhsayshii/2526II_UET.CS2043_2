interface Player {
    void play(String name);
}
class OldPlayer {
    public void playFile(String name) {
        System.out.println("Old player playing " + name);
    }
}

class PlayerAdapter implements Player {
    private final OldPlayer oldPlayer;
    public PlayerAdapter() {
        this.oldPlayer = new OldPlayer();
    }
    @Override
    public void play(String name) {
        oldPlayer.playFile(name);
    }
}

        
