package com.sjj.mashibing.command.audioPlayer;
/**
 * 具体命令角色-倒带命令
 */
public class StopCommand implements Command {
    private AudioPlayer myAudio;

    public StopCommand(AudioPlayer audioPlayer){
        myAudio = audioPlayer;
    }
    @Override
    public void execute() {
        myAudio.stop();
    }
}
