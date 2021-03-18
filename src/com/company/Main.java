package com.company;

import java.util.*;

public class Main {
    private static ArrayList<Album> albums = new ArrayList<>();
    public static void main(String[] args) {
//        ArrayList<Song> album = new ArrayList<>();
//        album.add(new Song("DDLJ",140));
//        album.add(new Song("YJHD",120));
//        album.add(new Song("John Wick",90));
//        album.add(new Song("Rambo last blood",110));
//
//        LinkedList<Song> playList = new LinkedList<>();
//        playList.addAll(album);

        Album album = new Album("Rockstar","AR rahman");
        album.addSong("Kun faya",4);
        album.addSong("Jo bhi main",3);
        album.addSong("Nadan Parindey",5);
        album.addSong("Mitti jaise sapne",4);
        album.addSong("Tum ho pass mere",3);

        albums.add(album);

        album = new Album("ChainSmoker","Brothers");
        album.addSong("Closer",4);
        album.addSong("Something just like this",3);
        album.addSong("Dont let me down",5);
        album.addSong("popstar",4);

        albums.add(album);

        LinkedList<Song> playlist = new LinkedList<>();
        albums.get(0).addToPlaylist("Kun faya",playlist);
        albums.get(1).addToPlaylist("Closer",playlist);
        albums.get(1).addToPlaylist("popstar",playlist);
        albums.get(1).addToPlaylist("Something just like this",playlist);



        play(playlist);



    }

    private static void play(LinkedList<Song> playList)
    {
        Scanner scanner = new Scanner(System.in);
        boolean quit = false;
        boolean forward = true;




        ListIterator<Song> listIterator = playList.listIterator();
        if(playList.size() == 0)
        {
            System.out.println("No Song in playlist");
        }
        else
        {
            // System.out.println("Now playing :" + listIterator.next().toString());
            printMenu();

        }

        while (!quit)
        {
            int action = scanner.nextInt();
            scanner.nextLine();

            switch (action)
            {
                case 0:
                    System.out.println("Playlist Complete");
                    quit = true;
                    break;
                case 1:
                    if(!forward)//LIST WAS MOVING IN BACKWARD DIRECTION
                    {
                        if(listIterator.hasNext())
                        {
                            listIterator.next();
                        }
                        forward =true;
                    }
                    if(listIterator.hasNext())
                        System.out.println("Now playing " + listIterator.next().toString());
                    else
                        System.out.println("We reached the end");
                    break;
                case 2:
                    if(forward)
                    {
                        if(listIterator.hasPrevious())
                        {
                            listIterator.previous();
                        }
                        forward = false;
                    }
                    if(listIterator.hasPrevious())
                    {
                        System.out.println("Now Playing "+ listIterator.previous().toString());
                    }
                    else
                        System.out.println("Reached the Start of playlist");
                    break;
                case 3://Replay
                    if(forward) {
                        if (listIterator.hasPrevious()) {
                            System.out.println("Now Replaying " + listIterator.previous().toString());
                            forward = false;
                        } else {
                            System.out.println("We are the start of the list");
                        }
                    }
                    else
                    {
                        if(listIterator.hasNext())
                        {
                            System.out.println("Now Playing "+ listIterator.next().toString());
                            forward = true;
                        }
                        else
                        {
                            System.out.println("Reached the End of List");
                        }
                    }
                    break;
                case 4: printList(playList);
                    break;
                case 5: printMenu();
                    break;
                case 6: //remove current song
                    if(playList.size()>0)
                    {
                        listIterator.remove();
                        if(listIterator.hasNext())
                            System.out.println("Now Playing " + listIterator.next());
                        else if(listIterator.hasPrevious())
                            System.out.println("Now playing " + listIterator.previous());
                    }
                    break;
            }
        }
    }

    private static  void printMenu()
    {
        System.out.println("Available options are :");
        System.out.println("0-> To Quit \t 1-> PlayNext \t 2-> Previous \t 3-> Replay \t 4-> list songs in playlist \t 5-> printAvailable Actions" +
                "\t 6 ->remove current song");
    }

    private static void printList(LinkedList<Song> playList)
    {
        Iterator<Song> iterator = playList.iterator();
        System.out.println("========================================================");
        while (iterator.hasNext())
        {
            System.out.println(iterator.next());
        }
        System.out.println("========================================================");
    }


}
