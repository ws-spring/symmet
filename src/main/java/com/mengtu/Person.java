package com.mengtu;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Person
{
    private int id;

    private String name;

    private int age;

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public int getAge()
    {
        return age;
    }

    public void setAge(int age)
    {
        this.age = age;
    }

    public Person(int id, String name, int age)
    {
        super();
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public Person()
    {
        super();
    }

    public static void main(String[] args)
    {

        // Set<String> pics = new HashSet<>();
        String htmlStr = "<div class=\"bd\" style=\"cursor: grab;\"><div class=\"webpreview-item\" data-id=\"1\" style=\"height: 1218px;\"><img oncontextmenu=\"return false;\" ondragstart=\"return false;\" onload=\"WebPreview.Image.onLoad(this)\" onerror=\"WebPreview.Image.onError(this)\" src=\"//file-1.book118.com/view3/M05/3A/3C/wKh2BVz3dTSANWS0AAEcZvVK59s921.png\" style=\"display: block;\"></div><div class=\"webpreview-split\">&nbsp;</div><div class=\"webpreview-item\" data-id=\"2\" style=\"height: 1218px;\"><img oncontextmenu=\"return false;\" ondragstart=\"return false;\" onload=\"WebPreview.Image.onLoad(this)\" onerror=\"WebPreview.Image.onError(this)\" src=\"//file-1.book118.com/view2/M05/3B/37/wKh2BVz3dTSAU-9IAAAQA9dQtm4985.png\" style=\"display: block;\"></div><div class=\"webpreview-split\">&nbsp;</div><div class=\"webpreview-item\" data-id=\"3\" style=\"height: 1218px;\"><img oncontextmenu=\"return false;\" ondragstart=\"return false;\" onload=\"WebPreview.Image.onLoad(this)\" onerror=\"WebPreview.Image.onError(this)\" class=\"\" data-src=\"//file-1.book118.com/view5/M00/36/3A/wKh2BFz3dTSAQCwuAABVbiy_aUI226.png\" src=\"//file-1.book118.com/view5/M00/36/3A/wKh2BFz3dTSAQCwuAABVbiy_aUI226.png\" style=\"display: block;\"></div><div class=\"webpreview-split\">&nbsp;</div><div class=\"webpreview-item\" data-id=\"4\" style=\"height: 1218px;\"><img oncontextmenu=\"return false;\" ondragstart=\"return false;\" onload=\"WebPreview.Image.onLoad(this)\" onerror=\"WebPreview.Image.onError(this)\" class=\"\" data-src=\"//file-1.book118.com/view3/M00/3A/3C/wKh2BVz3dTSAN1HWAABiHdGn19U627.png\" src=\"//file-1.book118.com/view3/M00/3A/3C/wKh2BVz3dTSAN1HWAABiHdGn19U627.png\" style=\"display: block;\"></div><div class=\"webpreview-split\">&nbsp;</div><div class=\"webpreview-item\" data-id=\"5\" style=\"height: 1218px;\"><img oncontextmenu=\"return false;\" ondragstart=\"return false;\" onload=\"WebPreview.Image.onLoad(this)\" onerror=\"WebPreview.Image.onError(this)\" class=\"\" data-src=\"//file-1.book118.com/view2/M01/3B/37/wKh2BVz3dTSAYjpGAABeC74-NHI161.png\" src=\"//file-1.book118.com/view2/M01/3B/37/wKh2BVz3dTSAYjpGAABeC74-NHI161.png\" style=\"display: block;\"></div><div class=\"webpreview-split\">&nbsp;</div><div class=\"webpreview-item\" data-id=\"6\" style=\"height: 1218px;\"><img oncontextmenu=\"return false;\" ondragstart=\"return false;\" onload=\"WebPreview.Image.onLoad(this)\" onerror=\"WebPreview.Image.onError(this)\" src=\"//file-1.book118.com/view3/M02/3A/3C/wKh2BVz3dTSAVwd9AABilPoMVas214.png\"></div><div class=\"webpreview-split\">&nbsp;</div><div class=\"webpreview-item\" data-id=\"7\" style=\"height: 1218px;\"><img oncontextmenu=\"return false;\" ondragstart=\"return false;\" onload=\"WebPreview.Image.onLoad(this)\" onerror=\"WebPreview.Image.onError(this)\" class=\"\" data-src=\"//file-1.book118.com/view4/M01/37/06/wKh2CVz3dTSAeqDvAABj1kM5vK4608.png\" src=\"//file-1.book118.com/view4/M01/37/06/wKh2CVz3dTSAeqDvAABj1kM5vK4608.png\" style=\"display: block;\"></div><div class=\"webpreview-split\">&nbsp;</div><div class=\"webpreview-item\" data-id=\"8\" style=\"height: 1218px;\"><img oncontextmenu=\"return false;\" ondragstart=\"return false;\" onload=\"WebPreview.Image.onLoad(this)\" onerror=\"WebPreview.Image.onError(this)\" class=\"\" data-src=\"//file-1.book118.com/view2/M02/3B/37/wKh2BVz3dTSAPhlwAABg6J2gEaM344.png\" src=\"//file-1.book118.com/view2/M02/3B/37/wKh2BVz3dTSAPhlwAABg6J2gEaM344.png\" style=\"display: block;\"></div><div class=\"webpreview-split\">&nbsp;</div><div class=\"webpreview-item\" data-id=\"9\" style=\"height: 1218px;\"><img oncontextmenu=\"return false;\" ondragstart=\"return false;\" onload=\"WebPreview.Image.onLoad(this)\" onerror=\"WebPreview.Image.onError(this)\" class=\"\" data-src=\"//file-1.book118.com/view3/M03/3A/3C/wKh2BVz3dTSAQqGXAAAQP3fMaBU828.png\" src=\"//file-1.book118.com/view3/M03/3A/3C/wKh2BVz3dTSAQqGXAAAQP3fMaBU828.png\" style=\"display: block;\"></div><div class=\"webpreview-split\">&nbsp;</div><div class=\"webpreview-item\" data-id=\"10\" style=\"height: 1218px;\"><img oncontextmenu=\"return false;\" ondragstart=\"return false;\" onload=\"WebPreview.Image.onLoad(this)\" onerror=\"WebPreview.Image.onError(this)\" class=\"\" data-src=\"//file-1.book118.com/view5/M01/1C/00/wKh2BFz3-aKANKy3AAEMXi6iy1w262.png\" src=\"//file-1.book118.com/view5/M01/1C/00/wKh2BFz3-aKANKy3AAEMXi6iy1w262.png\" style=\"display: block;\"></div><div class=\"webpreview-split\">&nbsp;</div><div class=\"webpreview-item\" data-id=\"11\" style=\"height: 1218px;\"><img oncontextmenu=\"return false;\" ondragstart=\"return false;\" onload=\"WebPreview.Image.onLoad(this)\" onerror=\"WebPreview.Image.onError(this)\" class=\"\" data-src=\"//file-1.book118.com/view2/M02/05/3D/wKh2BVz3-aKAXMPUAAEKStmd8tU871.png\" src=\"//file-1.book118.com/view2/M02/05/3D/wKh2BVz3-aKAXMPUAAEKStmd8tU871.png\" style=\"display: block;\"></div><div class=\"webpreview-split\">&nbsp;</div><div class=\"webpreview-item\" data-id=\"12\" style=\"height: 1218px;\"><img oncontextmenu=\"return false;\" ondragstart=\"return false;\" onload=\"WebPreview.Image.onLoad(this)\" onerror=\"WebPreview.Image.onError(this)\" class=\"\" data-src=\"//file-1.book118.com/view1/M05/08/02/wKh2BVz3-aKARhLwAACLxJpFTcU182.png\" src=\"//file-1.book118.com/view1/M05/08/02/wKh2BVz3-aKARhLwAACLxJpFTcU182.png\" style=\"display: block;\"></div><div class=\"webpreview-split\">&nbsp;</div><div class=\"webpreview-item\" data-id=\"13\" style=\"height: 1218px;\"><img oncontextmenu=\"return false;\" ondragstart=\"return false;\" onload=\"WebPreview.Image.onLoad(this)\" onerror=\"WebPreview.Image.onError(this)\" class=\"\" data-src=\"//file-1.book118.com/view1/M03/16/2E/wKh2BV0ZpbuAFZ6gAABm3EMlt6Q714.png\" src=\"//file-1.book118.com/view1/M03/16/2E/wKh2BV0ZpbuAFZ6gAABm3EMlt6Q714.png\" style=\"display: block;\"></div><div class=\"webpreview-split\">&nbsp;</div><div class=\"webpreview-item\" data-id=\"14\" style=\"height: 1218px;\"><img oncontextmenu=\"return false;\" ondragstart=\"return false;\" onload=\"WebPreview.Image.onLoad(this)\" onerror=\"WebPreview.Image.onError(this)\" class=\"\" data-src=\"//file-1.book118.com/view4/M01/13/06/wKh2Cl0ZpbuAOlllAABrZ14dXfA092.png\" src=\"//file-1.book118.com/view4/M01/13/06/wKh2Cl0ZpbuAOlllAABrZ14dXfA092.png\" style=\"display: block;\"></div><div class=\"webpreview-split\">&nbsp;</div><div class=\"webpreview-item\" data-id=\"15\" style=\"height: 1218px;\"><img oncontextmenu=\"return false;\" ondragstart=\"return false;\" onload=\"WebPreview.Image.onLoad(this)\" onerror=\"WebPreview.Image.onError(this)\" class=\"\" data-src=\"//file-1.book118.com/view5/M02/13/38/wKh2BF0ZpbyAfflbAAEqLDIQm-Q447.png\" src=\"//file-1.book118.com/view5/M02/13/38/wKh2BF0ZpbyAfflbAAEqLDIQm-Q447.png\" style=\"display: block;\"></div><div class=\"webpreview-split\">&nbsp;</div><div class=\"webpreview-item\" data-id=\"16\" style=\"height: 1218px;\"><img oncontextmenu=\"return false;\" ondragstart=\"return false;\" onload=\"WebPreview.Image.onLoad(this)\" onerror=\"WebPreview.Image.onError(this)\" class=\"\" data-src=\"//file-1.book118.com/view3/M00/0E/01/wKh2BV0ZpbuAUsYbAAGUTdCsQvs466.png\" src=\"//file-1.book118.com/view3/M00/0E/01/wKh2BV0ZpbuAUsYbAAGUTdCsQvs466.png\" style=\"display: block;\"></div><div class=\"webpreview-split\">&nbsp;</div><div class=\"webpreview-item\" data-id=\"17\" style=\"height: 1218px;\"><img oncontextmenu=\"return false;\" ondragstart=\"return false;\" onload=\"WebPreview.Image.onLoad(this)\" onerror=\"WebPreview.Image.onError(this)\" class=\"\" data-src=\"//file-1.book118.com/view6/M05/12/02/wKh2Cl0ZpbyABtFAAAF2cpPdT6s698.png\" src=\"//file-1.book118.com/view6/M05/12/02/wKh2Cl0ZpbyABtFAAAF2cpPdT6s698.png\" style=\"display: block;\"></div><div class=\"webpreview-split\">&nbsp;</div><div class=\"webpreview-item\" data-id=\"18\" style=\"height: 1218px;\"><img oncontextmenu=\"return false;\" ondragstart=\"return false;\" onload=\"WebPreview.Image.onLoad(this)\" onerror=\"WebPreview.Image.onError(this)\" class=\"\" data-src=\"//file-1.book118.com/view4/M04/13/06/wKh2Cl0ZpbuAZlUEAAFuFr9BvTo299.png\" src=\"//file-1.book118.com/view4/M04/13/06/wKh2Cl0ZpbuAZlUEAAFuFr9BvTo299.png\" style=\"display: block;\"></div><div class=\"webpreview-split\">&nbsp;</div><div class=\"webpreview-item\" data-id=\"19\" style=\"height: 1218px;\"><img oncontextmenu=\"return false;\" ondragstart=\"return false;\" onload=\"WebPreview.Image.onLoad(this)\" onerror=\"WebPreview.Image.onError(this)\" class=\"\" data-src=\"//file-1.book118.com/view2/M00/22/11/wKh2BF0ZpbuAKb1xAAFe0hDiSDE019.png\" src=\"//file-1.book118.com/view2/M00/22/11/wKh2BF0ZpbuAKb1xAAFe0hDiSDE019.png\" style=\"display: block;\"></div><div class=\"webpreview-split\">&nbsp;</div><div class=\"webpreview-item\" data-id=\"20\" style=\"height: 1218px;\"><img oncontextmenu=\"return false;\" ondragstart=\"return false;\" onload=\"WebPreview.Image.onLoad(this)\" onerror=\"WebPreview.Image.onError(this)\" class=\"\" data-src=\"//file-1.book118.com/view3/M05/0E/01/wKh2BV0ZpbuAG7VoAAE2Qbng7WQ571.png\" src=\"//file-1.book118.com/view3/M05/0E/01/wKh2BV0ZpbuAG7VoAAE2Qbng7WQ571.png\" style=\"display: block;\"></div><div class=\"webpreview-split\">&nbsp;</div><div class=\"webpreview-item\" data-id=\"21\" style=\"height: 1218px;\"><img oncontextmenu=\"return false;\" ondragstart=\"return false;\" onload=\"WebPreview.Image.onLoad(this)\" onerror=\"WebPreview.Image.onError(this)\" class=\"\" data-src=\"//file-1.book118.com/view2/M05/22/11/wKh2BF0ZpbyAbfCDAAHO8WaVqUk601.png\" src=\"//file-1.book118.com/view2/M05/22/11/wKh2BF0ZpbyAbfCDAAHO8WaVqUk601.png\" style=\"display: block;\"></div><div class=\"webpreview-split\">&nbsp;</div><div class=\"webpreview-item\" data-id=\"22\" style=\"height: 1218px;\"><img oncontextmenu=\"return false;\" ondragstart=\"return false;\" onload=\"WebPreview.Image.onLoad(this)\" onerror=\"WebPreview.Image.onError(this)\" class=\"\" data-src=\"//file-1.book118.com/view2/M01/22/11/wKh2BF0ZpbyAGVSRAAK_Ve7RW5Q964.png\" src=\"//file-1.book118.com/view2/M01/22/11/wKh2BF0ZpbyAGVSRAAK_Ve7RW5Q964.png\" style=\"display: block;\"></div><div class=\"webpreview-split\">&nbsp;</div><div class=\"webpreview-item\" data-id=\"23\" style=\"height: 1218px;\"><img oncontextmenu=\"return false;\" ondragstart=\"return false;\" onload=\"WebPreview.Image.onLoad(this)\" onerror=\"WebPreview.Image.onError(this)\" class=\"\" data-src=\"//file-1.book118.com/view1/M00/23/05/wKh2BF0ZpbuAIvJXAAILWZ4lqi8009.png\" src=\"//file-1.book118.com/view1/M00/23/05/wKh2BF0ZpbuAIvJXAAILWZ4lqi8009.png\" style=\"display: block;\"></div><div class=\"webpreview-split\">&nbsp;</div><div class=\"webpreview-item\" data-id=\"24\" style=\"height: 1218px;\"><img oncontextmenu=\"return false;\" ondragstart=\"return false;\" onload=\"WebPreview.Image.onLoad(this)\" onerror=\"WebPreview.Image.onError(this)\" class=\"\" data-src=\"//file-1.book118.com/view5/M01/13/38/wKh2BF0ZpbyAfOjBAAEptMtxyww779.png\" src=\"//file-1.book118.com/view5/M01/13/38/wKh2BF0ZpbyAfOjBAAEptMtxyww779.png\" style=\"display: block;\"></div><div class=\"webpreview-split\">&nbsp;</div><div class=\"webpreview-item\" data-id=\"25\" style=\"height: 1218px;\"><img oncontextmenu=\"return false;\" ondragstart=\"return false;\" onload=\"WebPreview.Image.onLoad(this)\" onerror=\"WebPreview.Image.onError(this)\" class=\"\" data-src=\"//file-1.book118.com/view1/M01/23/06/wKh2BF0ZpbyAD2w-AAD4xaYImDA198.png\" src=\"//file-1.book118.com/view1/M01/23/06/wKh2BF0ZpbyAD2w-AAD4xaYImDA198.png\" style=\"display: block;\"></div><div class=\"webpreview-split\">&nbsp;</div><div class=\"webpreview-item\" data-id=\"26\" style=\"height: 1218px;\"><img oncontextmenu=\"return false;\" ondragstart=\"return false;\" onload=\"WebPreview.Image.onLoad(this)\" onerror=\"WebPreview.Image.onError(this)\" class=\"\" data-src=\"//file-1.book118.com/view3/M00/0E/01/wKh2BV0ZpbyALjGuAADe347BEd0099.png\" src=\"//file-1.book118.com/view3/M00/0E/01/wKh2BV0ZpbyALjGuAADe347BEd0099.png\" style=\"display: block;\"></div><div class=\"webpreview-split\">&nbsp;</div><div class=\"webpreview-item\" data-id=\"27\" style=\"height: 1218px;\"><img oncontextmenu=\"return false;\" ondragstart=\"return false;\" onload=\"WebPreview.Image.onLoad(this)\" onerror=\"WebPreview.Image.onError(this)\" class=\"\" data-src=\"//file-1.book118.com/view3/M04/0E/01/wKh2BV0ZpbyAb-7qAAIqBWiIuyg615.png\" src=\"//file-1.book118.com/view3/M04/0E/01/wKh2BV0ZpbyAb-7qAAIqBWiIuyg615.png\" style=\"display: block;\"></div><div class=\"webpreview-split\">&nbsp;</div><div class=\"webpreview-item\" data-id=\"28\" style=\"height: 1218px;\"><img oncontextmenu=\"return false;\" ondragstart=\"return false;\" onload=\"WebPreview.Image.onLoad(this)\" onerror=\"WebPreview.Image.onError(this)\" class=\"\" data-src=\"//file-1.book118.com/view2/M02/14/2E/wKh2BV0ZpbyARyl1AADdpisgKBQ755.png\" src=\"//file-1.book118.com/view2/M02/14/2E/wKh2BV0ZpbyARyl1AADdpisgKBQ755.png\" style=\"display: block;\"></div><div class=\"webpreview-split\">&nbsp;</div></div>";
        String regEx_img1 = "<img.*src\\s*=\\s*(.*?)[^>]*?>";
        List<String> pics = resSrc(htmlStr, regEx_img1);
        Set<Integer> ss = new HashSet<>();
        for (String str : pics)
        {
            String temp = str.substring(64, 67);
            Integer temp1 = Integer.valueOf(str.substring(64, 67));
            System.out.println(str);
            System.out.println(temp);
            if((temp + "").split("").length>3) {
                temp1 = Integer.valueOf((temp + "").split("")[0]) + Integer.valueOf((temp + "").split("")[1])+ Integer.valueOf((temp + "").split("")[2]);
                ss.add(temp1);
            }
        }
        for (String str : pics)
        {
            Integer temp = Integer.valueOf(str.substring(65, 67));
            if (temp > 33)
            {
                temp = Integer.valueOf((temp + "").split("")[0]) + Integer.valueOf((temp + "").split("")[1]);
            }
            ss.add(temp);
        }
        System.out.println(ss.toString());
        String regEx_img2 = "<img.* data-src\\s*=\\s*(.*?)[^>]*?>";
        List<String> pics2 = resSrc(htmlStr, regEx_img2);
        
        Set<Integer> ss2 = new HashSet<>();
        for (String str : pics2)
        {
            Integer temp = Integer.valueOf(str.substring(65, 67));
            if (temp > 33)
            {
                temp = Integer.valueOf((temp + "").split("")[0]) + Integer.valueOf((temp + "").split("")[1]);
            }
            ss2.add(temp);
        }
        System.out.println(ss2.toString());
    }

    public static List<String> resSrc(String htmlStr, String regEx_img)
    {
        List<String> pics = new ArrayList<>();
        String img = "";
        Pattern p_image;
        Matcher m_image;
        // String regEx_img = "<img.*src=(.*?)[^>]*?>"; //图片链接地址
        p_image = Pattern.compile(regEx_img, Pattern.CASE_INSENSITIVE);
        m_image = p_image.matcher(htmlStr);
        while (m_image.find())
        {
            // 得到<img />数据
            img = m_image.group();
            // 匹配<img>中的src数据
            Matcher m = Pattern.compile("src\\s*=\\s*\"?(.*?)(\"|>|\\s+)").matcher(img);
            while (m.find())
            {
                pics.add(m.group(1));
            }
        }
        return pics;
    }

}
