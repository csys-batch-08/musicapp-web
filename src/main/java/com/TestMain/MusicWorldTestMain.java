package com.TestMain;

import java.util.*;
import java.sql.*;

import com.webmusic.DaoImpl.LibraryDao;
import com.webmusic.DaoImpl.LoginDao;
import com.webmusic.DaoImpl.PlaylistDao;
import com.webmusic.DaoImpl.UserInfoDao;
import com.webmusic.model.Library;
import com.webmusic.model.Playlist;
import com.webmusic.model.UserInfo;
import com.webmusic.util.ConnectionUtil;




public class MusicWorldTestMain {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		UserInfoDao obj = new UserInfoDao();

		Scanner sc = new Scanner(System.in);
		boolean flagCheck = false;
		int select;
		UserInfo checkUser = null;
		System.out.println(
				"                            'Welcome to MusicWorld' \n  Select your option: \n  1)Register/Signup \n  2)Login/Signin ");
		select = Integer.parseInt(sc.nextLine());

		switch (select) {
        
		// Register user
		case 1:

			String firstName;
			String lastName;
			String email_id;
			String userName;
			String password;
			String role;
			long mobileNumber = 0;

			do {
				System.out.println("Enter your firstName: ");
				firstName = sc.nextLine();
				if (firstName.matches("[a-zA-Z]+") && firstName != "") {
					// System.out.println("Your firstName is valid");
					flagCheck = false;
				} else {
					System.out.println("its invalid!!");
					flagCheck = true;
				}
			} while (flagCheck);

			do {
				System.out.println("Enter your lastName: ");
				lastName = sc.nextLine();
				if (lastName.matches("[a-zA-Z]+") && lastName != "") {
					// System.out.println("Your lastName is valid: ");
					flagCheck = false;
				} else {
					System.out.println("its invalid!!");
					flagCheck = true;
				}
			} while (flagCheck);

			do {
				System.out.println("Enter your email id: ");
				email_id = sc.nextLine();
				if (email_id.matches("[a-z0-9]+[@][a-z]+[.][a-z]+") && email_id != "") {
					// System.out.println("Your emailId is valid");
					flagCheck = false;
				} else {
					System.out.println("its invalid!!");
					flagCheck = true;
				}
			} while (flagCheck);

			do {
				System.out.println("Enter your userName: ");
				userName = sc.nextLine();
				if (userName.matches("[a-z]+") && userName != "") {
					// System.out.println("Your userName is valid");
					flagCheck = false;
				} else {
					System.out.println("its invalid!!");
					flagCheck = true;
				}
			} while (flagCheck);

			do {
				System.out.println("Enter your password: ");
				password = sc.nextLine();
				if (password.matches("[a-zA-Z0-9@#]+") && password != "") {
					// System.out.println("Your password is valid");
					flagCheck = false;
				} else {
					System.out.println("its invalid!!");
					flagCheck = true;
				}
			} while (flagCheck);

			do {
				System.out.println("Enter Your Role: ");
				role = sc.nextLine();
				if (role.matches("[a-zA-Z]+") && role != "") {
					// System.out.println("Your role is valid");
					flagCheck = false;
				} else {
					System.out.println("its invalid!!");
					flagCheck = true;
				}
			} while (flagCheck);

			do {
				System.out.println("Enter your mobileNumber: ");
				String check = sc.nextLine();
				if (check.matches("[0-9]{10}") && check != "") {
					// System.out.println("Your mobileNumber is valid");
					flagCheck = false;
					mobileNumber = Long.parseLong(check);
					break;
				} else {
					System.out.println("its invalid");
					flagCheck = true;
				}

			} while (flagCheck);

			UserInfo str = new UserInfo(firstName, lastName, email_id, userName, password, role, mobileNumber,0);
			UserInfoDao obj2 = new UserInfoDao();
			obj2.insertUser(str);
			
        
	    //Login portal
		case 2:
            System.out.println("----Login portal----");
			System.out.println("Enter your userName: ");
			String username = sc.nextLine();

			System.out.println("Enter your password: ");
			String passname = sc.nextLine();

			UserInfo str2 = new UserInfo();

			str2.setUserName(username);

			str2.setPassword(passname);

			Connection con = ConnectionUtil.getDBconnect();

			LoginDao obj1 = new LoginDao();
			//checkUser = obj1.login(str2);
			System.out.println(checkUser.getEmailId());
			break;


		default:
			System.out.println("Please enter the valid details!!!");
			break;
		}

		// Admin operations
		String choiceContinue = null;
		if (checkUser.getRole().equals("admin")) {
			do {
				System.out.println(
						"                       'Admin operations' \n  Select your option: \n  1)List all songs \t  2)Delete song \t  3)Add song \t  4)Update songs \t 5)List all users \t  6)Delete user \t 7)Show all playlist \t");
				select = Integer.parseInt(sc.nextLine());
				boolean choice;
				boolean choice1;

				switch (select) {

				//List all songs
				case 1:
					LibraryDao listSongs = new LibraryDao();
					List<Library> songList = listSongs.showAllSongs();
					for (int i = 0; i < songList.size(); i++) {
						System.out.println(songList.get(i));
					}

					System.out.println("If you want to sort: 1.yes 2.no");
					int choose = Integer.parseInt(sc.nextLine()) ;
					if (choose == 1) {
						System.out.println(
								"Choose the category: \n 1)Song title \n 2)Artists \n 3)Album \n 4)Genre \n 5)Language");
						int choose1 =Integer.parseInt(sc.nextLine()) ;
						switch (choose1) {
						case 1:
							 System.out.println("enter the song title");
							 String title = sc.nextLine();
							Library songTitle = null;
							for (Library l : songList) {
								if (l.getSongTitle().equalsIgnoreCase(title)) {
									songTitle = l;
								}
							}
							System.out.println(songTitle);
							break;
						case 2:
							System.out.println("enter the artists");
							 String artists = sc.nextLine();
							List<Library> songArtists = new ArrayList<Library>();
							for (Library l : songList) {
								if (l.getArtists().equalsIgnoreCase(artists)) {
									songArtists.add(l);
								}
							}
							for (int i = 0; i < songArtists.size(); i++) {
								System.out.println(songArtists.get(i));
							}

							break;

						case 3:
							System.out.println("enter the Album");
							 String album = sc.nextLine();
							List<Library> songAlbum = new ArrayList<Library>();
							for (Library l : songList) {
								if (l.getAlbum().equalsIgnoreCase(album)) {
									songAlbum.add(l);
								}
							}
							for (int i = 0; i < songAlbum.size(); i++) {
								System.out.println(songAlbum.get(i));
							}

							break;

						case 4:
							System.out.println("enter the genre");
							 String genre = sc.nextLine();
							List<Library> songGenre = new ArrayList<Library>();
							for (Library l : songList) {
								if (l.getGenre().equalsIgnoreCase(genre)) {
									songGenre.add(l);
								}
							}
							for (int i = 0; i < songGenre.size(); i++) {
								System.out.println(songGenre.get(i));
							}

							break;

						case 5:
							System.out.println("enter the language");
							 String language = sc.nextLine();
							List<Library> songLanguage = new ArrayList<Library>();
							for (Library l : songList) {
								if (l.getLanguage().equalsIgnoreCase(language)) {
									songLanguage.add(l);
								}
							}
							for (int i = 0; i < songLanguage.size(); i++) {
								System.out.println(songLanguage.get(i));
							}					
						}
					}
					break;

				//Delete song
				case 2:
					System.out.println("Enter song title to Delete here: ");
					String songTitle1 = sc.nextLine();
					LibraryDao lib3 = new LibraryDao();
					lib3.deleteSong(songTitle1);
					break;

				//Add song
				case 3:
					System.out.println("Enter song details to add here: ");

					Integer songId = 0;
					String songTitle;
					String userName;
					String artists;
					String album;
					String genre;
					String language;

					do {
						System.out.println("Enter song id: ");

						String songId1 = sc.nextLine();
						System.out.println(songId1);
						if (songId1.matches("[0-9]{2}") && songId1 != "" && songId1 != " ") {
							songId = Integer.parseInt(songId1);
							flagCheck = false;
						} else {
							System.out.println("its invalid!!");
							flagCheck = true;
						}
					} while (flagCheck);

					do {
						System.out.println("Enter songTitle: ");
						songTitle = sc.nextLine();
						if (songTitle.matches("[a-zA-Z_]+") && songTitle != "") {
							flagCheck = false;
						} else {
							System.out.println("its invalid!!");
							flagCheck = true;
						}
					} while (flagCheck);

					do {
						System.out.println("Enter userName: ");
						userName = sc.nextLine();
						if (userName.matches("[a-z]+") && userName != "") {
							flagCheck = false;
						} else {
							System.out.println("its invalid!!");
							flagCheck = true;
						}
					} while (flagCheck);

					do {
						System.out.println("Enter artists: ");
						artists = sc.nextLine();
						if (artists.matches("[a-zA-Z]+") && artists != "") {
							flagCheck = false;
						} else {
							System.out.println("its invalid!!");
							flagCheck = true;
						}
					} while (flagCheck);

					do {
						System.out.println("Enter album: ");
						album = sc.nextLine();
						if (album.matches("[a-zA-Z_]+") && album != "") {
							flagCheck = false;
						} else {
							System.out.println("its invalid!!");
							flagCheck = true;
						}
					} while (flagCheck);

					do {
						System.out.println("Enter genre: ");
						genre = sc.nextLine();
						if (genre.matches("[a-zA-Z]+") && genre != "") {
							flagCheck = false;
						} else {
							System.out.println("its invalid!!");
							flagCheck = true;
						}
					} while (flagCheck);

					do {
						System.out.println("Enter language: ");
						language = sc.nextLine();
						if (language.matches("[a-zA-Z]+") && language != "") {
							flagCheck = false;
						} else {
							System.out.println("its invalid!!");
							flagCheck = true;
						}
					} while (flagCheck);

					Library str3 = new Library(songId, songTitle, artists, album, genre, language);
					LibraryDao lib1 = new LibraryDao();
					lib1.insertLibrary(str3);
					break;

				// Update song
				case 4:
					System.out.println("Enter song details to updates here: ");

					Integer songId5 = 0;
					String songTitle2;
					String userName1;
					String artists1;
					String album1;
					String genre1;
					String language1;

					do {
						System.out.println("Enter song id: ");

						String songId2 = sc.nextLine();
						System.out.println(songId2);
						if (songId2.matches("[0-9]{2}") && songId2 != "" && songId2 != " ") {
							songId5 = Integer.parseInt(songId2);
							flagCheck = false;
						} else {
							System.out.println("its invalid!!");
							flagCheck = true;
						}
					} while (flagCheck);

					do {
						System.out.println("Enter songTitle: ");
						songTitle2 = sc.nextLine();
						if (songTitle2.matches("[a-zA-Z_]+") && songTitle2 != "") {
							flagCheck = false;
						} else {
							System.out.println("its invalid!!");
							flagCheck = true;
						}
					} while (flagCheck);

					do {
						System.out.println("Enter userName: ");
						userName1 = sc.nextLine();
						if (userName1.matches("[a-z]+") && userName1 != "") {
							flagCheck = false;
						} else {
							System.out.println("its invalid!!");
							flagCheck = true;
						}
					} while (flagCheck);

					do {
						System.out.println("Enter artists: ");
						artists1 = sc.nextLine();
						if (artists1.matches("[a-zA-Z]+") && artists1 != "") {
							flagCheck = false;
						} else {
							System.out.println("its invalid!!");
							flagCheck = true;
						}
					} while (flagCheck);

					do {
						System.out.println("Enter album: ");
						album1 = sc.nextLine();
						if (album1.matches("[a-zA-Z_]+") && album1 != "") {
							flagCheck = false;
						} else {
							System.out.println("its invalid!!");
							flagCheck = true;
						}
					} while (flagCheck);

					do {
						System.out.println("Enter genre: ");
						genre1 = sc.nextLine();
						if (genre1.matches("[a-zA-Z]+") && genre1 != "") {
							flagCheck = false;
						} else {
							System.out.println("its invalid!!");
							flagCheck = true;
						}
					} while (flagCheck);

					do {
						System.out.println("Enter language: ");
						language1 = sc.nextLine();
						if (language1.matches("[a-zA-Z]+") && language1 != "") {
							flagCheck = false;
						} else {
							System.out.println("its invalid!!");
							flagCheck = true;
						}
					} while (flagCheck);

					Library up = new Library(songId5, songTitle2, artists1, album1, genre1, language1);
					LibraryDao lib2 = new LibraryDao();
					lib2.update(up);
					break;
                
				// List all Users
				case 5:
					UserInfoDao listUsers = new UserInfoDao();
					List<UserInfo> userList = listUsers.showAllUsers();
					for (int i = 0; i < userList.size(); i++) {
						System.out.println(userList.get(i));
					}
					break;
					
				// Delete user
				case 6:
					System.out.println("Enter the User_name to delete ");
					 userName1 = sc.nextLine();
					obj.delete(userName1);
					break;	
					
				// List all playlist
				case 7:
					PlaylistDao showPlaylist = new PlaylistDao();
					List<Playlist> playlist = showPlaylist.showAllPlaylist();
					for (int i = 0; i < playlist.size(); i++) {
						System.out.println(playlist.get(i));
					}
					break;
				default:
					System.out.println("Please enter the valid details!!!");
				}
				System.out.println("Do you want to continue Yes  or  NO ");
				choiceContinue = sc.nextLine();
			} while (choiceContinue.equalsIgnoreCase("yes"));

		}else {
			do {
				System.out.println(
						"                    \n  Select your option: \n 1)List all songs \n 2)Update User \n 3)Add playlist \n 4)Delete Playlist \n 5)Recharge wallet \n 6)Switch to premium user \n 7)Add On User");
				select = Integer.parseInt(sc.nextLine());
				boolean choice;
				boolean choice1;

				switch (select) {

				//List all songs
				case 1:
					LibraryDao listSongs = new LibraryDao();
					List<Library> songList = listSongs.showAllSongs();
					for (int i = 0; i < songList.size(); i++) {
						System.out.println(songList.get(i));
					}

					System.out.println("If you want to sort: 1.yes 2.no");
					int choose = Integer.parseInt(sc.nextLine()) ;
					if (choose == 1) {
						System.out.println(
								"Choose the category: \n 1)Song title \n 2)Artists \n 3)Album \n 4)Genre \n 5)Language");
						int choose1 =Integer.parseInt(sc.nextLine()) ;
						switch (choose1) {
						case 1:
							 System.out.println("Enter the song title");
							 String title = sc.nextLine();
							Library songTitle = null;
							for (Library l : songList) {
								if (l.getSongTitle().equalsIgnoreCase(title)) {
									songTitle = l;
								}
							}
							System.out.println(songTitle);
							break;
						case 2:
							System.out.println("Enter the artist name");
							 String artists = sc.nextLine();
							List<Library> songArtists = new ArrayList<Library>();
							for (Library l : songList) {
								if (l.getArtists().equalsIgnoreCase(artists)) {
									songArtists.add(l);
								}
							}
							for (int i = 0; i < songArtists.size(); i++) {
								System.out.println(songArtists.get(i));
							}

							break;

						case 3:
							System.out.println("Enter the Album name");
							 String album = sc.nextLine();
							List<Library> songAlbum = new ArrayList<Library>();
							for (Library l : songList) {
								if (l.getAlbum().equalsIgnoreCase(album)) {
									songAlbum.add(l);
								}
							}
							for (int i = 0; i < songAlbum.size(); i++) {
								System.out.println(songAlbum.get(i));
							}

							break;

						case 4:
							System.out.println("Enter the genre name");
							 String genre = sc.nextLine();
							List<Library> songGenre = new ArrayList<Library>();
							for (Library l : songList) {
								if (l.getGenre().equalsIgnoreCase(genre)) {
									songGenre.add(l);
								}
							}
							for (int i = 0; i < songGenre.size(); i++) {
								System.out.println(songGenre.get(i));
							}

							break;

						case 5:
							System.out.println("Enter the language name");
							 String language = sc.nextLine();
							List<Library> songLanguage = new ArrayList<Library>();
							for (Library l : songList) {
								if (l.getLanguage().equalsIgnoreCase(language)) {
									songLanguage.add(l);
								}
							}
							for (int i = 0; i < songLanguage.size(); i++) {
								System.out.println(songLanguage.get(i));
							}		
						}					
					}
					break;
                 
				//Update user 
				case 2:
					System.out.println("Enter to update user details");
					String firstName1;
					String lastName1;
					//String email_id1;
					String userName11;
					String password1;
					//String role1;
					long mobileNumber1 = 0;

					do {
						System.out.println("Enter your firstName: ");
						firstName1 = sc.nextLine();
						if (firstName1.matches("[a-zA-Z]+") && firstName1 != "") {
							// System.out.println("Your firstName is valid");
							flagCheck = false;
						} else {
							System.out.println("its invalid!!");
							flagCheck = true;
						}
					} while (flagCheck);

					do {
						System.out.println("Enter your lastName: ");
						lastName1 = sc.nextLine();
						if (lastName1.matches("[a-zA-Z]+") && lastName1 != "") {
							// System.out.println("Your lastName is valid: ");
							flagCheck = false;
						} else {
							System.out.println("its invalid!!");
							flagCheck = true;
						}
					} while (flagCheck);

					do {
						System.out.println("Enter your userName: ");
						userName11 = sc.nextLine();
						if (userName11.matches("[a-z]+") && userName11 != "") {
							// System.out.println("Your userName is valid");
							flagCheck = false;
						} else {
							System.out.println("its invalid!!");
							flagCheck = true;
						}
					} while (flagCheck);

					do {
						System.out.println("Enter your password: ");
						password1 = sc.nextLine();
						if (password1.matches("[a-zA-Z0-9@#]+") && password1 != "") {
							// System.out.println("Your password is valid");
							flagCheck = false;
						} else {
							System.out.println("its invalid!!");
							flagCheck = true;
						}
					} while (flagCheck);

					do {
						System.out.println("Enter your mobileNumber: ");
						String check = sc.nextLine();
						if (check.matches("[0-9]{10}") && check != "") {
							// System.out.println("Your mobileNumber is valid");
							flagCheck = false;
							mobileNumber1 = Long.parseLong(check);
							break;
						} else {
							System.out.println("its invalid");
							flagCheck = true;
						}

					} while (flagCheck);
					
					checkUser.setFirstName(firstName1);
					checkUser.setLastName(lastName1);
					checkUser.setPassword(password1);
					checkUser.setUserName(userName11);
					checkUser.setMobileNumber(mobileNumber1);
				
					//UserInfo str1 = new UserInfo(firstName1, lastName1, email_id1, userName11, password1, role1, mobileNumber1,0);
					UserInfoDao obj21 = new UserInfoDao();
					obj21.update(checkUser);
					
				break;
				
				//Add playlist
				case 3:
					System.out.println("Enter playlist Title");
					String playlistTitle = sc.nextLine();
					PlaylistDao playDao = new PlaylistDao();
					// int playlistId=playDao.findPlaylistId(playlistTitle);
                    //System.out.println("Enter playList id:");
                    //int playlistId =Integer.parseInt(sc.nextLine());
					System.out.println("Enter email Id");
					String emailId = sc.nextLine();
					System.out.println("Enter song title");
					String songTitle = sc.nextLine();
					LibraryDao libDao = new LibraryDao();
					Library song = libDao.findSong(songTitle);
					Playlist playList = new Playlist(song, playlistTitle, emailId);

					playDao.insertPlaylist(playList);
					break;
				
				//Delete playlist
				case 4:
					System.out.println("Enter playlist title to Delete here: ");
					String deletePlaylist = sc.nextLine();
					PlaylistDao del = new PlaylistDao();
					del.deletePlaylist(deletePlaylist,checkUser);
					break;
				
				//Recharge wallet
				case 5:
					System.out.println("Recharge here");
					System.out.println("Enter amount");
					double amount = Double.parseDouble(sc.nextLine());
					System.out.println("Enter card number");
					long cardNo = Long.parseLong(sc.nextLine());
					System.out.println("Enter cvv");
					int cvv = Integer.parseInt(sc.nextLine());
					checkUser.setWallet(amount);
					UserInfoDao userDao = new UserInfoDao();
					userDao.UpdateUserWallet(checkUser);
					System.out.println("Do you want to continue Yes  or  No ");
					
					break;
				
				//Switch to premium user
				case 6:
					System.out.println("Switch to premium user here: ");
					System.out.println("Switch to premium for 150Rs per year");
					UserInfoDao userInfoDao= new UserInfoDao();
					userInfoDao.SwitchToPremium(checkUser);
					System.out.println("Do you want to continue Yes  or  No ");
					
					break;
				
				//Add on user
				case 7:
					System.out.println("Enter present user email id to share premium account!!");
					System.out.println("Enter email id");
					String email = sc.nextLine();
					UserInfoDao userDao1 = new UserInfoDao();
					userDao1.AddOnUser(email);
					
					break;
				
				default:
					System.out.println("Please enter the valid details!!!");
				}
				System.out.println("Do you want to continue Yes  or  No ");
				choiceContinue = sc.nextLine();
			} while (choiceContinue.equalsIgnoreCase("yes"));

		  }
		}
	}


