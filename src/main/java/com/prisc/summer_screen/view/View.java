package com.prisc.summer_screen.view;

import com.prisc.summer_screen.model.EpisodeInfo;
import com.prisc.summer_screen.model.SeasonInfo;
import com.prisc.summer_screen.model.SeriesInfo;
import com.prisc.summer_screen.service.OmdbApiConsumer;

import java.util.Scanner;

public class View {

    private final Scanner SCAN = new Scanner(System.in);
    private final OmdbApiConsumer OMDB_CONSUMER = new OmdbApiConsumer();

    private void printSummerScreen(){
        System.out.println("""
				 ▗▄▄▖█  ▐▌▄▄▄▄  ▄▄▄▄  ▗▞▀▚▖ ▄▄▄      ▗▄▄▖▗▞▀▘ ▄▄▄ ▗▞▀▚▖▗▞▀▚▖▄▄▄▄ \s
				▐▌   ▀▄▄▞▘█ █ █ █ █ █ ▐▛▀▀▘█        ▐▌   ▝▚▄▖█    ▐▛▀▀▘▐▛▀▀▘█   █\s
				 ▝▀▚▖     █   █ █   █ ▝▚▄▄▖█         ▝▀▚▖    █    ▝▚▄▄▖▝▚▄▄▖█   █\s
				▗▄▄▞▘                               ▗▄▄▞▘                        \s\s
				""");
    }


    public void initSummerScreen(){
        printSummerScreen();
        mainMenu();
    }

    private void mainMenu(){
        var exit = false;
        while(!exit) {

            String option = null;
            System.out.println("Encontre sua série favorita !");
            System.out.print("""
                    1 - Procurar
                    0 - SAIR
                    >>\s""");
            option = SCAN.nextLine();
            var validOption = ViewUtil.validateUserOption(option, 0, 1);
            switch (validOption) {
                case -1:
                    System.out.println("\n## Opção inválida!");
                    break;
                case  0:
                    exit = true;
                    break;
                case  1:
                    exit = !findSeries();
                    break;
            }
        }
    }

    public boolean findSeries(){
        var serie = readValidSeriesName();
        if(serie != null){
            SeriesInfo seriesInfo = OMDB_CONSUMER.getSeriesInfo(serie);
            if (seriesInfo.totalSeasons() == null) {
                System.out.println("\n## Desculpe, não encontramos a série \'" + serie.toUpperCase() + "\' ##\n");
            } else {
                System.out.println("\n## Buscando... ");
                var seasons = OMDB_CONSUMER.getAllEpisodesInfo(serie);
                printSeriesInfo(seriesInfo);
                seasons.forEach(this::printSeasonInfo);
                System.out.println("\n ***  FIM DOS EPISÓDIOS  ***");
                System.out.println();

            }
            return true;
        }
        return false;
    }

    private String readValidSeriesName() {
        while (true) {
            String serie = promptUserForSeriesName();

            if (ViewUtil.validateSerieName(serie)) {
                return serie;
            }

            System.out.println("\n## Série inválida ##");
            if (!handleInvalidInput("Tentar novamente")) {
                return null;
            }
        }
    }

    private String promptUserForSeriesName() {
        System.out.println("Nos diga o nome da série:");
        System.out.print(">> ");
        return SCAN.nextLine();
    }

    private boolean handleInvalidInput(String option1) {
        while (true) {
            System.out.println("1 - " + option1);
            System.out.println("0 - SAIR");
            System.out.print(">> ");

            String userOption = SCAN.nextLine();
            int validUserOption = ViewUtil.validateUserOption(userOption, 0, 1);

            if (validUserOption == 0) {
                return false;
            } else if (validUserOption == 1) {
                return true;
            } else {
                System.out.println("\n## Escolha uma opção válida ##");
            }
        }
    }

    private void printSeriesInfo(SeriesInfo serieInfo){
        System.out.println("\n *** " + serieInfo.title().toUpperCase() + " ***");
        System.out.println("Temporadas: " + serieInfo.totalSeasons());
        System.out.println("Classificação: "+ serieInfo.rating());
        System.out.println();
    }

    private void printSeasonInfo(SeasonInfo season){
        System.out.println("** Temporada " + season.season() + " **");
        season.episodes().forEach(this::printEpisodeInfo);
    }

    private  void printEpisodeInfo(EpisodeInfo episode){
        System.out.println("\t " + episode.episode() + " - " + episode.title());
    }
}
