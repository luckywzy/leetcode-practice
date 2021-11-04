package com.code.leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @author wangzongyu
 * @Description:
 * @date 2021/11/3 3:58 下午
 */
public class Solution271Test {

    @Test
    public void encode() {
        Solution271 solution271 = new Solution271();
        List<String> strs = new ArrayList<>();
        strs.add("abc");
        strs.add("aaa");
        strs.add("");
        strs.add("bbb");
        String encode = solution271.encode(strs);
        List<String> decode = solution271.decode(encode);

        for (int i = 0; i < decode.size(); i++) {
            Assert.assertEquals(strs.get(i), decode.get(i));
        }
    }

    @Test
    public void encode1() {
        Solution271 solution271 = new Solution271();
        List<String> strs = new ArrayList<>();
        String encode = solution271.encode(strs);
        List<String> decode = solution271.decode(encode);

        for (int i = 0; i < decode.size(); i++) {
            Assert.assertEquals(strs.get(i), decode.get(i));
        }
    }


    @Test
    public void encode3() {
        Solution271 solution271 = new Solution271();
        List<String> strs = new ArrayList<>();
        String[] ss = new String[]{
                "5AgU$/Cr);iz&(b|wDU~*PcO|p<Nz",
                "4*t):ES^E)i^",
                "fNiT.+C6waLqrGRZ`J-ZO1mKA>e2CdM9zF3`O<nf2 T#t!ZJsN 96yz0h3I=q:8)D@|50T/Lj2.!VGAn=%Li{J`y_*/cG(Q%1qOxh}G@rW[s<X",
                "sbP!|ZWRq`y,-}aFk$Owx!%uxBJwI?rHPy6/qe^!38}1.1tu)LA-$z~2eVuvMydE~~,(MtI#vsBs^c+=6ea]~;t,n8k8LiC!]yjYR1 y.b{",
                "&8i]7{0`yCoq1Jxge(~z+q`)0Nl81d1HQ19l?TjHIT6`+y0iED]Wf/B^|rSV+SVF?HcTDp4y+%:-D#kRZdw<<oS,!Hx S)_)w>w!r`@2=sd(EdFK$EcJ*|W{HB7m]#?;$e4wKKu4bwtQjh8DE/Xehml6(!hB*I",
                "Jnx8ugODPuyl+,+0^)*5q#MovdX#DXEo |i>0Pa.6]];{:[mc<g]hw:94Kmj5~SzLIwf([j<]|6,*,3xJw `BD#}]1,!{4U}(yi~J;q",
                "gAAb,Z$iY-]$l6IoIA/@g!ne#wqd1>S Lfy.5@jrZ4(v^GsBml].Bf=669YXH(T!.W.8Hz_FfxZe^L(?~*}}tXpKs3;<Qy3bKQwiw7RMkZ1XQw&V2j{rr01m2RMXOA[k+)Ahez",
                "NyV[a@,GUMl:D]<GvxWeVNh8&PU70Dj(;]A1@KZ{=*(~ZSs-DN=.Lwpm$Jb_jRckIf]IUts?:t0{^-3D@o0YLqPq,4&G@Op`33m;x+Z5v!e+U>0PL>THiJ 1x.:?x+OJ~887U*-LxpA!mW,sNHYUPz|(qO; 0e66YElcJJm-v+`#[O",
                "1,.MKP8z-)RJ|cMyaqP&2E:,NU&;QR?k!!5TiH8B+R%#FClK-5W5_AZ[w)%R+s!p#JTAB#Ma)0IbZOQ*{Q`MfK.|F2zZr[0QST-/4Y~bTJgsXRUP]GMjYeh?*&@:6]@o#fXTw3Z#4U`i_59b2nV~h~JSm,b8,EL!8en_zQDY.x3@I(yM%I#JO2^mRQob@qCa=8",
                "`GH;*0A1ClL@2|adyMcW@6jh2}Q%5*UHQo6v4fJ",
                "}U=}DA*5Z)<RMTtJm}jVsqmIH>_r}yh;^@ 5P`DCeN-5jqB?if#k%6IOzgNB~<K>e$c2}g=l@k5 >GtAc$@_|C`*. #c3tC]oD+]C6^s&QCc8b+r:_Q.$`CyfOM+uB8AJ8o;SXCh~8NrL|Z,PMvN6GTLT8czf|k",
                "@DH-WdmT%NFM^}2t?iDYxL}e=v3q,Q(fvCTIZAzCf/R08,^Q!7>;N@~AP;&S@",
                "[Afs-ccN^53^ju~9d/nJjs@Gp^J`p?VCXGomcs|NQ&k&>w2(<-*0",
                "F1b@IWanK4ON(qSks<VGDPCkqj,~78lcq]:-wOf~55^J{(/$Oz.Pm={Q*b*Eo*vN(QTm^Ki; [4gYi6@BY`qCKX~{W5Vfb5=`s-)kk:-g+ 5r[@AEbk+8)Z$Ms%*$[KF*C /_^1!|G^}NSLXm0r(L0;=",
                "6s2f(U#|V>y8H:Rp8Cr>8y1BKw>YX$:A>D0 >6-.eF?.G~.:: rGXvdmA74MZ|1^b}i&O.j%A^nbji/%=Q5Q-@_U$0qd3_+$j/3=3Tp+Q]G^dg?Tp37>",
                "%Xu. d}NL6X@btCZQtC3A|{!g[@B`(&7Oa)X;xPNys&uTBm1}s-3TF3h7AA_A6rOlp[1nG(da5E6|L, ]CRvdRX$SA[FGx-arn}Vv$br>:|8s@+/O<Z3TcL _otIpG0BeT[SI}EB!D)vq62T<^odDo,u+rT102*Z_a3jGR|2Kx#/*hEld3T#%ELrg+2~n`zPp*QY@",
                "p.A75CZPA @%xsXZE=?w3O#=HtybKvv;yIykioBj^pv]?mb2<",
                "@PtM[%2bW-DB*A_!<#ZD9Ar&KO+!BHtc~(#uC,px<TFc}^~b4p0W1e-wImLNKs[BODN4o$mWpBO~w2J+)))WS(v-~$!2LUbZ 7tjl;Jaw&PH4ESJstfow7a!2<$`DI$Ofr",
                ")W`STPs_<Aqi$<E>-vgNk&tCe?[A!^qEKAX>D|FFMw#WbLN#%Fh#OQQf;B<PH=Hw+|9-OTh>ND-hE @iKve9RW<d7hco$+l",
                "UIhasMl|6S/WSOd,.pn,dR86 }xNYzbb>V>D<FW1d n2)`Z-`N P#Vr2a@|-$vna<tOm-2:t.~t(dO6k4nE,vD",
                "8aD5dY$[CBw%",
                "bW}uevl<lAjJR<6#sC4%$k(4x6r9Mexe!P?__77)PjS`r.K$xKB[N6h",
                "S<Hy:Ke^].pe-94:$0+xeo#`}rt`?jJ]Vo+yX~55xqToAdGBrxV",
                ".qB3Jn<hmNT0dHo+C(+&){r]|f}_1ia|bLW",
                "=[G+.jB+!*|x%OaiU=!-3mX9n4N&<4{ed<HK<&*Abne9L_D!k&&Wr472ofp$K%udj1rlwJl2br2:*Y-h-:^0LemLz1uU!/Fcj_TQ(7Z)kbk$a]fN=ucbOtjP*WT%YM#@hU[X=1O##)g{C2Q~yZ@rNJ_5!kO^s@60YYvM~d4",
                "OXcYkdjmN_CuU4m=+X.+l<70roS~f#U!7<>p-U;uejaqWK-2Wb-Im@Mf?o$faL0eIYST:Wxv8WT:2[I435f716D,!]- [;MtHexZTwi]Z{-Efyt2frhnj+wR{b}:2w4pkbKi!9n6ze35Q`xh7EJ.G*SkkfM#,y `ZeAr::VFae",
                "qj3Bwf!x~+hd|cja1xu&=Bw*I!2|Ma7<8bolS`Vg+!E<=dgg9:?k>`f)?Q/+I8e7HN[[}{i`m HO{=Q1fqmGH?PKEe!Pol0GCRb=!}s^>y^QD5cj7TA",
                "g`|Gg gxq,:h^Zo#g[&7[%hYk}<[AVC%=!fL8JC/*<oG/X7jC#|m9v^$Ao,Qp3?PnBkyi6ZP(I>sX)a,@7h<,u!9BeS`Q;v7G{*pS1_&XzFCzVOj!<:fcVJa]9:gN1D-m+_P",
                "ycGatRZ<W:@0eo?M#C3mubh6/~MNdzL!J&HS.bS6hIs$84,ZA.$6[VNiWhbaJ6W!v)A-kIINs2d01#NEqFatv %[sTGK 0fyOPu:/z?:hn-RA[;~L567eqv7zs/>10--~_7>TR`/K91e|zmh9/.T(0`dS9!7T9",
                "GLO@X6a.v>byK,tCFx&l}>D&czNo~>5x<j;DO]9EL`d+dP40,<C^zG0Z-cI?[-@)V#as@1`+*&fsX9YZ<9O0@#pHq0Hb[qn8q*-WbAge]t$uRbm}",
                "w(;pzpCqrB LCOqsx92tl};1r=K{NVl~G?w-W%Opa5Km>St.(w}zp@p0^>-Rv DI7Q3F`;qv]rVJLF",
                "",
                ".J&p,*X9,~Imx[O8~?7ieXqeV1@QHLG1],j[(dg[Rgha9<!_@8GMpHbE?r&]SI{n{ m[#T[!-% pH,yB)9oawYB?Qc*`uPb+o]Irj2ngr/TZ!Nl PyOFx`u[??~c!Gy+RPs`^",
                "w!2#!04`w#MXQRJV<_ev(wwh+qCoy]P>! ^+RV_a.",
                ".C9Z_[.uIF%:=jW]G6uP`bBfHj{V[P8(~%Bu1UC-r~3G&tkHSIYT(,ir>W:#L]Y>qfm~Mu([^U@%713X#a*O(|A!T>|y>jVFvn?B-P+8D;Qn#p[qvJKFVGO:?P@ypELll5*=vgQZbT-b7(>m/k@]C*f0Cxa$k|+m",
                "rRPW^/vRqY;eBUD}DrcwbRqYj$?b:fMpRI6v6x-Z(BUI?;DNrc/xM=vK2xVqy._8NM%a1O!SbW.oF>f98k)CJ6tqH7c3P6 VTYbiWZN$db(I*;~sGfTlxgmRx F@F-{oLM-v@5WcfM>49C?B;j/hDr|zTiyXajO,.6tCuiI",
                ":*EYb_Bj%SaT_tK+]8Nl&*[,jn}e~v__wBeho{tapPhIA[2vV!&sz#n{Xxz56D>~+:<r/?y`>3PW&=[Kj",
                "mbf-P(y!OqTm02k/]5-YUU:Yq=6q~3t/ShK/rjIt%v2:dXn};+~<}O!wEbbrV.$)9!mU{wMT7lI=gowj;w-_YTL9e;M`<H0(DkUB0{&!;tsqPxhgu",
                "Y19|Iht:jdXRI<h_^kOCIvUKS6a!-y#McyZ~h09Bv}NCYjPf/74+o]+<o,keUy?SZcI<FV6ocp Nl#L**V6bF3m<Uxd36J %",
                "Be3Iv,EK]I1C1,_WkUV#`Lht",
                "2^wmE_.~8fB,?S/J)6-c53@kVlN0W:)u;1VMf<+RdpvBfo)d;=Q@i.wY_K`hY_ZN$~J9ta7q,p%WKv;V6e@0JW9vq<PsU-^!7X^[2!:8@T[9-|R@}zAeR[$}m>xnq/.Y[zdvNXi_.,qS1H$nVa^{FCB)(S5-tlQ1g)@0<cL17L$%O($^][[kT(&rtz9@#`yC ]O",
                "y.muN@wKK|`x8[%v)~W/<?$or:xAxt4Ol/qs_k|(c#V*Bnq.V^Q^p/p>8:^X36u@`To5IJooRf8l@2~dSJO9m*4f Dh@nEyq%)h[knqT3tQ|E#HSSka72m:c>n6o:BaQV,Xl!E):^7K1Sv2_bZ`4a~J*qZ|C_g78",
                "O4;wGZZUEG!3@q1>Cp,71USe.3M#;:xL;BJE%Qe:!>,T]d$m(-^;`:KNg$-!eabS0}B#/0vx*}<pQ-zFBzb^ ~z.A+VQ*r*,4Oi/:5&Dm^5P?syl_IxifwivXYG$4|Z>Ew6$_MX|(jAbFzA-:8k&D",
                "H*i4vOgUcprF52}N@",
                "v4p=jJL$A5b;_+=LRW)TLc/fiy,8adP-)7Q{5G-XkI7fL6=UxCferbPnUb;h6Ur}YHGQc()3>;o2$7O>,",
                "{<3OQ@0)P?=uXIhU}(x9hB",
                "*4v0*E1BPZFVG1^h* =7@ <(QUmI:5V",
                ">TA_$lV__hU.yl$47qxBOVAlA4S`^lbL5u1`0B:iJFcV|fg;LBk[,cL>nsAa0>/QBYcaJ;Q S*V7H0h;F|?ErtlQ Hox84o&Md2rF3$YB4n=H Jnd0)e-m,",
                "Sx9!gA(1{g*<{lR<M<<jmr2E)UY;R2jh:I:T_=b3qr/idb,uZh1Q$IXVzZ;PKYG0$y~ra",
                "8",
                "[xHVZ-{cG;l7V&lKl?LQo|iE$8?tp%c|-7JNleJ0S>MidE2*Y|p/hP8WZ?m5vOMmd",
                "sD%?i0&:jQ_/P3bqr]oX&QT<4fgy#It4Li_/-)emAb9wdIFwHCcSw{CXQe[Zg.uLNZkwT#Do~ah!mw7kq*bH~{K8N/sT4-uM{9:g3}/hHSd<b(. |v*;`JU7*N0bq~xF,!6Zgq",
                ")Y/_{FA&i`F;[t;eiVtTG7;WXj|;*/o F-D",
                " vH?(-)W,})y>K[Y[}){{<oYbMKU^+r/D`I&bq=yC6-h(2kO^;/im5Pu9YYUxDO5)-8i0B1~n.0P]3@n^iOU(ng9ch07S{m`.&7/HR1nACUn{0T:<&|j+nNRxto_m3&ElD[t%X3_j7tQ@76!",
                "F7Y69=:@Q)5:5O|RFM}G_hL,Ru:QhnpnO5d.{V5*qj572*<~6zoU;A!d;%Q]tAUsF=6KCg~3t^?Mq,o5P?s?=",
                "2l=!46}+DO/#IYY>CY|TkAWvN#|5q1/R<<G%!",
                "@fBIF}vNYPBhM<Gsg|h7L{!6dOn_bW :9iDXJ`}6G5E>A^j<.",
                "Y{B1^zL@jI%GidLP26b??_",
                "dti>Z]P[%hf^rL:3d7Z3Vv>nS;c.kAkbi5s<a9?;/yvGCZ`(@XUV8%5 D36`,v>*DR+",
                ">RJ5+[?L>6|-l(|sAe($",
                "`=kewQ,C{e3bTW#x4`w~oi::PP<mtJ8KxdkG[m2zVCq0WI`GK`|I5<Fnoa3=;$tU Y2!HOBC.VKbHDyl=EfKE7CW(TT-a%><x;[5&P2PQZ",
                "K},`d$Yha%q<03~f:`@1}K/z)t`JSp.p<QP:bNE}LZX(g~1QFXZ!1ualhsYY)+/fB/*pin[p1QnA50o7|",
                "5yq[{sgG4vf.wtc8A2phHI;~b6B.oeA31x]YNcu|Gg:BE_s5{@ypDDtM,=i**u!k,v$^FR_v)K*a;Z5GZXlz<>$)",
                "|2iiZsZ=q{@V<efI[Y<w8}$;@%)8M.RJF eX;bBie,<EGGFHrUA4(QHcQo4qyR-QlBrAA@c0OwWK6SQC%7X_>((a6b_>FR~P2|dx{r8M6?k@N>X <b9lX+2Uy<+>D@8N (#4n{gSL(33YwsU_.y?R",
                "KfsC4y<:zHwvfe8skT*|IjRr!Fiy|z}_1No6|Ku:poZg$>@ wj|=~S4K#R;Gky[09G`4-UEkvT_w|Kfm(s.lC$%200;-G|",
                "o&SD~yo!C6o-H@kb*k5N(Q<k0Ac)dwhYFkee c]1}-1,Es@52A K=p@#T9/s4G))093Vo<e/pAX$NuSm-z",
                "!d#v)^Z|4%,&tRx+n= |N3xUkG7.>T*mRbpgz}rH[|eZ&_;xoJA:-@.TkaHK.5fP{~D+w4q<QnJ@~j|;|g!6-#w_8UGC:2y4_3>#hCYP58m9#,4;",
                "q|^Lwfks&j7%,W6%@U}^#BL7OwhX{Kk}EE=kzB8/MZ",
                "%zhC*tv|9M}0e#-:B?gOZFpz+e]VpusfQ@(~FN_u`Mg6=FWmxbDkj+i#FXSgd^)o?SFl=#l}tnc8,>GZZ>@lb:iDlUXTpbEb6=c",
                "R]XE*}zm#eGu7m9 QUo{5]Ld%YdTvFORG#UVTZxX}",
                "#qgVddL.{oB8XdG7g82hZ1.B4An19R!tfo_Yf!5lY|WMA(xA}dX*A?99~rUqw?&W_L:K?U/(ZPG.ca^Wj*Cx4=,?&Fa]OMgkcp7btj`oc`%.gl;#nM}M#=Q*",
                "}($rMNWb6Q{FuqF=2]",
                "~v*<U[8]Er(kz$cOy.&${k`P,J:nGIz3fk)y7Fg2!5wO",
                "Z[p?RRK8<T Uv;{[W5i9.SXKKKN@Wh{*++CxM$r(3@Z0q92d.Q}#0>@I]ARa@Nw.wMz)JzBb8A1F:}!C(-lBi_]ZEi$n",
                "_Sqw7UbyrM5AG46sY BSsPDiZ5`K[dk;#[q[)_~&Zr^A8owR9VzLyS^r^a@fV4I0]B_#KSHGUd{w?m&l<~/eB+oUKWh1w|lDHA",
                "ns/qeUJklHJS8oiy3%%X%hGGeyFrJuk8dpvbcf`R4r@ofxyY?!@k)k>}4DZkQywo>,uwm7Wq/bg^W-jV97LG+B-8;[D",
                "2,ep?^mQUz6YCM3Ol9zTF6#`&FPALb@aH$bO-W3n@:aA3SLD^2k1ZIQ",
                "@)2k+ve7mhwT[,PzK%llxxa1^^[s&ri`_nt7P7gIyP[7EPiq4b^q",
                "/SNiE#$C+u._?Q3->OO0UHHGYeIv%~r+",
                "@6j8ZhOEg`*fZ?!(E2<+_#v#F lzg>{;5x-.trImw>1AM(b>I]~J:P]Igl(W;^zh[94;6<jc m`xbXGXZ?W:apNvVHfDx2|{q0HU,GuvvH+m0w1+`nLP!0ML~$y$9]jG,cP92f8,umDo3pjQJ(r-)(2(0GQ73^m2k6B}9gn,/<:ewb*Yk|2W8i6[sq{3CygI>",
                ">f>WDum $KG`*qHx(;y ^bdM8?K^*+NEE#>/OJOXoA",
                "iXUZ_u{:2@dQ<xcYh,EPt/Bvk`we+9X%@bq[<`P&K19>m18+;F+WYuhsq[nEl.;$^?>E>yW2CH|1aPeu,kxfF3~(j3cB>N/;kv i/K+86:O&`,^iJ8tcuxo++-!$1*b2St/<d8>x1/[4iMcjZQd^$8vxHvP",
                "wynGjb]fTBU-F&A4$:e1h>e/E0D_2d<gzZZ;r5wHPTc(nWHs|FHjY*BKX4A2 >,3M|Rj-k6 w_]MoCfOMB&(m8W#s%Rc>dD)tN1+TR$1eg*q#)-,+?lXDF2C]2NsG!5J=_&I;]o.qs%5rngcN",
                "sWk$U$>+#UcFPY}wbS1[M*J$$TI%1%n>l;uqTk_?GXR]S1~g<snx.FM#]] ORZ+8f,>]G|",
                "wD;ROa:#ek-&:D)<`f0PYQn/JH(:C4Q q&j+VB!n*5xq1#!yiBEzq2-Olf0t}zm]xUA`W/vu.+@XE!T-lQE>-vZHib3rjP:#DxlG$kf{~^!,L{a^F8& M.]Xm_n6|_5. Pq6!b-23X|rZ[!p{Z72 V3s568HLIr8ONKO",
                "%P/L/rXB-64q)GX2>QK**W)(M.wH[}:8<YVtk+v26r:1,dU)wRV9{ WJ@T61/*h.+u3M[;:7*{ONHU1Zjn5l=sQg1RwG]C[$BiO3b7iL#p>zY_4;<>}e?^)?`5#$Y.y3cr:q=q/=6e2F(i{N?<%~{.VhX ?Yrg[g|y0:UhFnS/t,?",
                "{|&_U~->B97f<GzZ$FT[Ig8T!F[Y2|~x>zpDlJT6oq,GPE5cO-db:,q__@q*{m*+;$/K|tVkgB_I8kvIe;;8?Nm?6~*;v9BHn3+23/y{9&nVBb@xg8U JB&<BIo7Bxb]P[(:j*D5+&{:G^w|f0`@b;&k}qB*z !lk0gG+WsZw*jFnVk1w5 Jcvv D4j7",
                "_jhVK>~vsu*@<Ri!J.",
                "(y1?<*7;KlgBv{s1>7ys6eiF^l/i*D-y2a(JwXK_j^5|:vCo:fM6X2e}m3W ULM>;sf8J1WSsx7IcANyY2<-.gM{3Wkhd9CU+hdL7kWIH3$g9MK}lfq&=F:CKe$,>Ue/6BiF{Mo7IWa|c.Sx^X^V",
                "+x{C",
                "nYrB4kJ62@OrSp>AYY45eTohCk8Gw|>vKRA.e9w@cWCa]^2TZ`GS URwmQ=nUQ<=nW4]%+b3;amz~PTED^PNO!@g=}oDDFVkAO3j9XX",
                "&i=< sn_{]y#!h_V=aGsOeFp.-G",
                "~$44AKX$hfrRrwhF.)Iz1 iKD}5`Nf>3-T.U/|hK{)K}BIH7Obe3,f$ipv}d^x[8vc",
                "`V@U8x}1cbqr8kBH3lmcUMo56}<ej{wnl=2rB%Y",
                "4B)Zlr266WS1gX&syoE]>dmF&`%b]!x+[IesyrX5{MdM 8>h`GKj0/GC",
                "eR!}v7E4KN=EiC.N(}-{iIW04jyY-d>if7IPoVC1UVI>b*7;0:<ZWHy?0%1otQHJsP>#3qyz)9(YQ[G-{+%W/wd?BhAi@}m3e@As191H..BwzGlS(0m]L3+A<8wUnY-s67Y{JW,73;EQxa2GO+n)+RTXHRWy",
                "^$=VvW[)7f4ix@`rr}v##OM?skg-x&mcf?E>=;bjkQ^(px#|6!o)Pp|s)m!#Y*L8k=H:*nnACNI=%gHt4g%Dv+52nZg$h.Tl]$.`^Id#a,LGJG3A$~rQAxz2Kpie|MlqD6i %+g",
                "$SRjpXu/K>Mg4Hx@@zwm$x~H:zR7;zbEN+m&{7O.Esno[;E~C3=p78fy0tLA/j#o>!y9|A^[V4QsaL&:K2Jz`H{+NK/t>}6O@ 4Nb,g5hllFC94 I.,4re+DI cIDU",
                "w",
                "kZff5jpUphzi<R<X9X^>oRlcCs nXSf-F8T7:zGKf<sB~Pe4@}O2tKc_t/#bBa8_~cVjq4&u(<sJ1Ed{YY>5@> Q5ji)f(3KKBh<uj<SMf]$PXN};1FfA1AYuPzCb<`e?b0Y5B!ejV}6",
                "Eox.826a5H2/&FRl[PfV<6{S/U-]|U tUN<7t1rZj^<DZ<3Ic6#cZo6aU8jl[*zcOq|/=./[O-&P",
                "aja$>",
                "Y{u%_:2/&_!9x`w_3jF<YAW-P*(kRS",
                "DFJNF#g eF-= ~bG7Pe/QH/S03(",
                "2z=.E&wvgDV.iFJ_;k`5y2-?[LP~372v$?Xl_H_s7P$:}C%`3ZNawMC-T6K8:Go53 ;*UK+{WSq6",
                "ho||s*A6|$@F/F|Vw@PU|(_/&lC9a#6YcRRLaU%+<-d_E1++4kj:w^Q|JJ`WdW7O0>WbvqrGBEn[a;&|Go4a6XgTiaK,k$$ 6tjYLt>xIY<@p@Fr3X? hDf)<",
                "U4RFsxjg _;i^QUUm8Nd 6w.w-@4(J/B?oIzY6(E*qbu!FdZs+j2W_W~tk*RA(5uF{uq&x2[9SWB_y4njyP",
                "(:fnxUkH$3X1h{l9@1ZC`;7Q@>}2oM>_DPtJ1PxV",
                "N}YXoUT.=ml$9.+g/roklhf967E70x(y?iEL:YBU_p/Z3^OQMtuD5*bZJ(]5fdX{W~!a~F,_^C8P8/no3",
                "4#L-SmWz&$C~x?i(d0TV:b-",
                "z{?K7Wp8OexeL!WU-.l%jo.aTxU-:aOK .;keGM0?3/bW1z*}Y,_e|Y(v9K>E|ndDed=orz_SX#T",
                ":Ab5Z{-hU;dq#X{= St69~5ZJ@Eq8Faeo3iWb@%3QV|6Q`TZ1D|FJJ/gqRgR.-,dz,VO<=BL]_}<A1VwMM2VebQ[ 9X k|2dG_r_RyPu~]*y~i)icybv5fvdA)9vl}_BBf-<DHBFOQG!I-z`9DEz.5=_!@e*[dwtdeQHe",
                "dwRpaW5AlZ~]9dLyhDpE9~rs4``i",
                "7/S=29PprQ9QsLPKuOAL(1gfa&-{xMb*JMT%);!9;N4/.%$UxmshdK2s(!_94T=x8moJ3s`tjJS}G;1z}J7Z;57hL`J=&]KOLOnLBAkFPExw>K&@*x8h05bEsevEepyi#nIIyn^;)<8S9xn[exk02d?W^`=e`;U=5i`w#]6{Nz)L5>%zw$El&:q>1EojOWHLQe",
                "*@Lc#VPbLq+Bfnxhm*W9-rYtw_Er29`DyjhIUa,%sIffut(0TmU=O.0uWXwg3@,mL6m%Z;iJ|]/OKD=%mOz/.LXw,EoIVDOpT@w$!C-s--INe#<p_/etvj%[p,>f$j/z",
                ":l&V,qy[!q8UYmw79T#Bj^e6HU6q2#JqJ,O+Z1T|*L<SlE%HO*t[7#t`R1^45(xK B}mn9CB)nUtdkE<C&;a>X1}p7m8>oAF4N4HTQ~?+!Tujo<U}Y;W^:{i90]H|t.ok)rrQ-&1iB]DjWM6#aK86yBM%D9,oC@eDEf,{icq+Km|nCx!Jwe]D+,A|!cZKr#oo!rxcO",
                "ZS)0,bD4i}e9rGOu&!#aGQ3wcm<{75{R#~6%=5=@^%z2^R#tnqL`b-`S=DcJgSQ3P2TS*-v$7:2*MT8#KiN.@Dr3M)@FU-y%>j0?zumQLgpjfA.}Y/:gGxj*zN=3*J94O}1*;Rq2pP4(hp:oTSbW<.dEm7",
                "if.j.tBYpe]a<bwDBx,$|feXpFRoL01}qZ4,H.c`FQJ(Wr1 -s-8Na",
                "E/67%Xl7@74{Qr*p*V[hsIW~4 BB6ROHUQ^_nX.lEKJz,UT7aR%ds1DL$,!Lc<Ks5=HSY,cj;o`K5A.@sc-|Tu*hs?79TKd0P?l9<Y",
                "~;ZA+Qot8ve%Qgk{RqRChUW`Rc2N, -TV,U$z8 (5+ntx?:mhnE/[@32x`#?XA/|3fk^Q}8ht#UUGJ4$_+L",
                "f(w|K`_(9X~8L5y]#8nq|RJCyoku7-Nn~Hoe3@S:_:b]e}ZcR]%CiM}5g fN^?{<=@]SmeZn_c,W?;/y-y[,qMbr!oVk98Cx@16Cvg3>f4+-J,L:S~43}2zrIO-Pd_KZs@H/L2{3F[q+rHF@?kHfj<3H(q4`cb3D>R<=:b",
                "uBiN-xiRqkpu#Ta5]L|8M0agw8g3y3ouO1E;y%q<bpiG5jPn(c}.nwj3D#o(G ]ujf!z%{I)fiq[",
                "z6J~=;pHAHKYh3dfwg3*7G]uZMKHwSCG2k#RFHqmuR54,`UIR[Y~XH0os#E2]#6(%Ipag((8yE.*C+MoCtJbE8z.kR6NFCxF~I8_/b{kgsu]YkO+KM.wg8%H;patnznu/C4KVfnH4MDf[",
                "f`U[r(K~mtUt*(:`4p@Rld&rv5>)hc)4U#0:tkTKI-x.:B",
                "[fUV!JmgkjK]TJ;#R8|iQeq:@Mn!Wfi*g UG WIDk#|j7S2(B2%BKxoDs5>cS0w Clr9EKL:uVa%2*ue)L^$c1x6P2",
                "SL%*Z$Y6I&nm%^H0`nUc_,fkSQ9 hR8Cjy$<ocQFH{6cF{}*ExYfOt.,,yd+=jp1kB-J0-2(a%6O|Vq >xNPg(W&uutQ;",
                "4?>m;v]u${.3uI`5wB1M2#A Y{pgqb7)hc+g!|P S)-ls>gW0lK>-C2v}QKTa0=4UA;2KEz],A?~f)$26d=WE63EWt8vdd.{zNnF/a6;q484 *c*F{N[ (QGe4&>Hv]v#t7oF}",
                "Bp8x[:[{*O[Mj]iq@HbQ%A):Jlef_&z}.V%Q59q]NI]OSY^3%{W5(+/w>gQW:s7[*,P:udO,:VP*4LI`:@S 2*t{ve)wlh8>8*.GJ,u^B5xec",
                "Gu,CVL;dn5E,(W<B4gnX0YV`y?]x$b;sn(L5qse!jqb::5yNnC(p&x-)D>~RDcm+H^}P*Nohr/yy1}}B7`Jhux2Cq0_0<Vbv+<ji45s7d?w[xa&x%eMwz?y$#v(}_>dtR0HXxSEYTY]OJ1+gs|.S_iNKrgo;uR1pVssK&/Som",
                ",$%c-,S~^:CnCup#|z]D)UZQ[ALD5`z^@-*<zyGcm/LRXb=JXV+_F6UDJ2)lK(F)dJ[Yw]tr^ic,*ijp=dUYtR<0*<fH1rXOk1u*RvORXS$*;,#S=Bfz:WnQ2",
                "j^yRKbZFDw6?um_vq{5Wo^wVlnqX}xPulE<m)k+DWoM*]L3B./E:ja:G#kMB.&ijygjqe_m46K%>(1[!xY8;Vw#.RH{LU$yl^OD ,j,spvPw;rRQ+n)j,K.a4<BOcTl6=okW-_g%",
                "{QDzIY!9+64[Bwi*ieFn*cKrL_E,PuX2Ry+z]P+d3TRVY|z~$93suRz&-x!$~*%G}",
                "L.d?3^{gyu[HZVXDROb{UQrgM6!$(iZ)!Dh0>Uf[vOgQ7(D~hig<*bU8b]hD<z<E5#]^n6EOVpZW??S?,18uljUCFYv",
                "hIlBh$sVw,)IbG9Mn.KzM LVQoI?no<|ISX6`-C;f!lJm4uVZ1A..aEmc4wW=zZ+QNtL6HjJLY-",
                ")X6$z!oy*:<vCOU)c|jyj-f]_.Kj# uoDi*|)w/I4fjr)`g]uU54[G+OL7MFqK8iWdk+j8@W%ih(lt8=V]8OFXi<N5TL@;E[?V]_1d[aLh)0z:<&`~o(D3PNk?Kq0J@p",
                "U@^jG/;v_#W5$ fqUn}twTA@~)w]EDk>RvoWVAfF*lY,(DA?M`V2?)@$$2p1%.Nlrm~g&RAH,$`{Kg{-_T&-kz:9I-2,| 4c6Wk+xK},;*hWSdDM*cdA^gb].N1f61Llm:_/",
                "pKj+J>OmCfa#-Tnr9pFx|0^n?6p Q#q6mYcejMJovC1,akPSp{O`n2c",
                "cKSxJv5ZyVcPv5*)){6FRXRQj{?EbgMA-#MWN_|X&*#sbereBUt7|}g4KrXy;M_az9) m8$!&Kq}V*kDp:A/riD!)AWG|o>.i/gr_><Y/6Ax>9!K:[i:cpAwxPEZ#G_ Y8W.YOQM #G%If$|dt?c7. pm#jU",
                "CXiU+rkpmVmWu]o@j",
                "]iBqPwey@11N",
                "Vj!]}Q~KfB4eNIWhQ;6o)V5|.xW9t~",
                "MZ3[#f0sPb+R~gnDQ pC1k<)LF@=z3?A1d2Ab{gQgpP_kIpo_5dnQSU{w]YL;#4#>7#4<bj0e~$G|5QYr>ozO!2#zG+@x~y%:;ax|[*^Wj]nxb={D.T.mQ#lPpiw?`Ux+ (^g0X.W.{,D;C3e@5 F@~@U{[{F",
                "2f/|4kBKG:{zIVy){z)NQ}.y-+%9KLbKbvymb` +ulUnNLB0N@2-kKNlskiR5lLjM<n}Js x63hgZ1*iQx.!Q*yjvtkv1J3iT+</y#O:0fn{.f=:S-XH(S|QY88TgB`HD hx~KZ?5RlrP[",
                ",XIO6BaRe*R72Sc c1D]6=~)f~wEA%.`hpy-3zos",
                "/02(>wD8%Bx5(pj",
                "qt$G{>:8wC7&h?$.&Kv,0VZAtMObd`Nml7c~3AcV=|,!Vh4^X%WoqzC1,+bed4QFNhg5vd:{RGavqen`C=M2GA)1hiiq(3=&F6[K.Q7oP@pl-;gh%dp^Q]xDyFxgXgtcKaHaRG54Xa-XpE(udip&3b<<*$J",
                "Zl98c~X-5tX,#n%KH>0e]9rNJU(X0aJ<8gWKs*?L9]8|`5up>:^w[p5=$[!",
                "3+{1?lE%C9UoX@+Y`)UfP<6iPS!H0ZnO]XnOZVl*),Gkz&4>A7axXHC:C+gFH~&0%%wvPd(@{5O|K 3&|gfJAF< ZhUorx@B<3@ZuzZ_.E=-ih{xnb.xp=jt:eS%U*j6!",
                "2Zx.An.&lgBsYoU8WYq7Pon.|D!+?5L2EQ>r3UKN?`0L87S`i%T1S @1vO$<)^s?&rPe#`O<vA;-99[I(7+",
                "XJr$S,pMp0Az|gBTt$sj= POzULi~aTn`YC!2Kji/V$h3q%T43G<IaB(8Qk;C:TY9$Y,W7BA?S8e@p%},rK.(s-0R{}ZwB;O(2oZvTne37|sXxQgy9wXwx612;A([!%",
                "&v1vP}MWRkb>0<!6?pRg{dptEKtlmq%p){,PlUNv[Qok`I84&F(pmGyAHUKIE$-x8!r~[n4chs{?|BU|5fUl;e;",
                "WM`lUu`yigWsgVeqx?*D5EeTc{+E8ySwv( ?y x%uF3%&r`g@16$C:!Y!>_t24cI#Rm$sh~z*rW&9&LH3*49!qH2u)nkYb?x,3j$B94vU;.G&wUZv=h>+2xnI1r{~#Q0DVUyhF82]YXe-F@:q+9mk=E0$umu%;YGCh=C[IpJI7wYAZ&|(2S]:",
                "&N$MFLIC./Hm==zrH^D+dYMl7y;.05EHer/ofy4h|g|A&>1#e)A<czf[^2U8o7tUp~ivq8h.*d8t7X{l.7p(CydI@Fno>z+Cs$ &QoUI&N IeBs;9VE<7hDGB=Mn;aFbKaTeh.&FR{8h",
                "l=*+VwQP3pR3 ymsWP9`Sm;XbJ8?&o C&AOg-Ad|To(.-|V!#*}eDntj/z /UP[V>$r`!MJ#K1|*KTB*a2_O0aWkW)=HP73J`,-h|zkl)ETbn/)Qr[C; 0@NI3g3%<S/%tQK9[zebP62^lZWqJ5J{J9*0RcS/r`V?pSX",
                "fi>FalFOS?MjO|-`D~n*)2%r&cQTjc9v(0R{L<`VfV7KLK?jKog[sM{?lD~QRrW9#_wI#XaD=d (e!dlW!)K?#4Gf;6R,"
        };
        String encode = solution271.encode(Arrays.asList(ss));
        List<String> decode = solution271.decode(encode);

        for (int i = 0; i < decode.size(); i++) {
            Assert.assertEquals(ss[i], decode.get(i));
        }
    }
}