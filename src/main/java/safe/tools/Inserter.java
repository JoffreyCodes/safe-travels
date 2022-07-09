package safe.tools;

import safe.dal.MaskUseDao;
import safe.dal.ProfileDao;
import safe.model.MaskUse;
import safe.model.Profile;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Inserter {

  public static void main(String[] args) throws SQLException {
    MaskUseDao maskUseDao = MaskUseDao.getInstance();
    Integer maskUseId = 5;
    List<MaskUse> getMaskUseByIdList = maskUseDao.getMaskUseByMaskUseId(maskUseId);
    for(MaskUse getMaskUseById : getMaskUseByIdList) {
      System.out.format("Getting maskUseId %s: CountyFIPS:%s Always:%s Frequently:%s Sometimes:%s Rarely:%s Never:%s\n",
        getMaskUseById.getMaskUseId(),
        getMaskUseById.getCountyFIPS(),
        getMaskUseById.getALWAYS(),
        getMaskUseById.getFREQUENTLY(),
        getMaskUseById.getSOMETIMES(),
        getMaskUseById.getRARELY(),
        getMaskUseById.getNEVER()
      );
    }

    ProfileDao profileDao = ProfileDao.getInstance();
    List<Profile> profiles = profileDao.getProfileByName("Washington");
    for(Profile profile: profiles){
      System.out.format("profileId:%s covCased:%s", profile.getProfileId(), profile.getCovidCases()+"\n");
    }


  }
}



