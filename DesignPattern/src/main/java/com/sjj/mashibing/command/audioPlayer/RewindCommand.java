package com.sjj.mashibing.command.audioPlayer;
/**
 * 具体命令角色-倒带命令
 */
public class RewindCommand implements Command {

    private AudioPlayer myAudio;

    public RewindCommand(AudioPlayer audioPlayer){
        myAudio = audioPlayer;
    }
    /**
     * 执行方法
     */
    @Override
    public void execute() {
        myAudio.rewind();
    }
}
