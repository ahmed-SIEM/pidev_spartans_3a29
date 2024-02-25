package controllers;

import entity.Terrain;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import services.TerrainService;

import java.util.ArrayList;
import java.util.List;

public class PageTerrainController  {




        @FXML
        private AnchorPane BOX1;

        @FXML
        private AnchorPane BOX2;

        @FXML
        private AnchorPane BOX3;

        @FXML
        private ImageView Img1;

        @FXML
        private ImageView Img2;

        @FXML
        private ImageView Img3;

        @FXML
        private AnchorPane MainPane;

        @FXML
        private Text address1;

        @FXML
        private Text address2;

        @FXML
        private Text address3;

        @FXML
        private Button btnDetail1;

        @FXML
        private Button btnModif1;

        @FXML
        private Button btnModif2;

        @FXML
        private Button btnModif3;

        @FXML
        private Button btnSupp1;

        @FXML
        private Button btnSupp2;

        @FXML
        private Button btnajout;

        @FXML
        private Button btndetail2;

        @FXML
        private Button btndetail3;

        @FXML
        private Button btnretour;

        @FXML
        private Button btnsuivant;

        @FXML
        private Button btnsupp3;

        @FXML
        private Text nom1;

        @FXML
        private Text nom2;

        @FXML
        private Text nom3;

        /*

        BOX1 :
        nom1
        address1
        btnDetail1
    btnSupp1
    btnModif1
    Img1

        * */
   int i= 0;



        TerrainService Ts = new TerrainService();

    public void initialize() {

         actualise(Ts.getAllTerrains());
    }

    void actualise(List<Terrain> terrains){
        if(terrains.size()-1-i*3>0){
            btnsuivant.setVisible(true);
        }

        if(terrains.size()-1-i*3 <= 0){
            btnsuivant.setVisible(false);
        }
        if(i > 0){
            btnretour.setVisible(true);
        }

        if(i == 0){
            btnretour.setVisible(false);
        }
        if(!terrains.isEmpty()){
            if(terrains.size()-1-i*3>=0){
                BOX1.setVisible(true);
                nom1.setText(terrains.get(i*3).getNomTerrain());
                address1.setText(terrains.get(i*3).getAddress());
                Img1.setImage(new Image(terrains.get(i*3).getImage()));

            }else{

                BOX1.setVisible(false);
            }
            if(terrains.size()-2-i*3>=0){
                BOX2.setVisible(true);
                nom2.setText(terrains.get(1+i*3).getNomTerrain());
                address2.setText(terrains.get(1+i*3).getAddress());
                Img2.setImage(new Image(terrains.get(1+i*3).getImage()));
            }else{
                BOX2.setVisible(false);
            }
            if(terrains.size()-3-i*3>=0){
                BOX3.setVisible(true);
                nom3.setText(terrains.get(2+i*3).getNomTerrain());
                address3.setText(terrains.get(2+i*3).getAddress());
                Img3.setImage(new Image(terrains.get(2+i*3).getImage()));
            }else{
                BOX3.setVisible(false);

            }


        }
    }
    @FXML
    void retour(ActionEvent event) {
            i -=1;
      actualise(Ts.getAllTerrains());
    }

    @FXML
    void suivant(ActionEvent event) {
        i +=1;
        actualise(Ts.getAllTerrains());

    }
        @FXML
        void Ajout(ActionEvent event) {

        }

        @FXML
        void Modif1(ActionEvent event) {

        }

        @FXML
        void detail1(ActionEvent event) {

        }

        @FXML
        void detail2(ActionEvent event) {

        }

        @FXML
        void detail3(ActionEvent event) {

        }

        @FXML
        void modif2(ActionEvent event) {

        }

        @FXML
        void modif3(ActionEvent event) {

        }



        @FXML
        void supp1(ActionEvent event) {

        }

        @FXML
        void supp2(ActionEvent event) {

        }

        @FXML
        void supp3(ActionEvent event) {

        }

    }


