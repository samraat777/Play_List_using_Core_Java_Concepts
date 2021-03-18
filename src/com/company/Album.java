package com.company;

import java.util.ArrayList;
import java.util.LinkedList;

public class Album {
    private String name;
    private String artist;
    private ArrayList<Song> songs ;

    public Album(String name, String artist) {
        this.name = name;
        this.artist = artist;
        this.songs = new ArrayList<Song>();
    }

    public boolean addSong(String title,int duration)
    {
        if(findSong(title) == null)
        {
            this.songs.add(new Song(title,duration));
            return true;
        }
        return false;
    }

    private Song findSong(String title)
    {
        for(Song checkSong : this.songs)
        {
            if(checkSong.getTitle().equals(title))
                return checkSong;
        }
        return null;
    }
    public boolean addToPlaylist(int trackNo, LinkedList<Song> playlist)
    {
        int index = trackNo-1;
        if(index>=0 && index< this.songs.size())
        {
            playlist.add(songs.get(index));
            return true;
        }
        System.out.println("Not a song");
        return false;
    }

    public boolean addToPlaylist(String title, LinkedList<Song> playlist)
    {
        Song checkedSong = findSong(title);
        if(checkedSong!=null)
        {
            playlist.add(checkedSong);
            return true;
        }
        System.out.println("Not a song");
        return false;
    }


}

