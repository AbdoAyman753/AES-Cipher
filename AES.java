package sample;


import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class AES {
    static final int[] SBox =  {0x63, 0x7c, 0x77, 0x7b, 0xf2, 0x6b, 0x6f, 0xc5, 0x30, 0x01, 0x67, 0x2b, 0xfe, 0xd7, 0xab, 0x76,
                                0xca, 0x82, 0xc9, 0x7d, 0xfa, 0x59, 0x47, 0xf0, 0xad, 0xd4, 0xa2, 0xaf, 0x9c, 0xa4, 0x72, 0xc0,
                                0xb7, 0xfd, 0x93, 0x26, 0x36, 0x3f, 0xf7, 0xcc, 0x34, 0xa5, 0xe5, 0xf1, 0x71, 0xd8, 0x31, 0x15,
                                0x04, 0xc7, 0x23, 0xc3, 0x18, 0x96, 0x05, 0x9a, 0x07, 0x12, 0x80, 0xe2, 0xeb, 0x27, 0xb2, 0x75,
                                0x09, 0x83, 0x2c, 0x1a, 0x1b, 0x6e, 0x5a, 0xa0, 0x52, 0x3b, 0xd6, 0xb3, 0x29, 0xe3, 0x2f, 0x84,
                                0x53, 0xd1, 0x00, 0xed, 0x20, 0xfc, 0xb1, 0x5b, 0x6a, 0xcb, 0xbe, 0x39, 0x4a, 0x4c, 0x58, 0xcf,
                                0xd0, 0xef, 0xaa, 0xfb, 0x43, 0x4d, 0x33, 0x85, 0x45, 0xf9, 0x02, 0x7f, 0x50, 0x3c, 0x9f, 0xa8,
                                0x51, 0xa3, 0x40, 0x8f, 0x92, 0x9d, 0x38, 0xf5, 0xbc, 0xb6, 0xda, 0x21, 0x10, 0xff, 0xf3, 0xd2,
                                0xcd, 0x0c, 0x13, 0xec, 0x5f, 0x97, 0x44, 0x17, 0xc4, 0xa7, 0x7e, 0x3d, 0x64, 0x5d, 0x19, 0x73,
                                0x60, 0x81, 0x4f, 0xdc, 0x22, 0x2a, 0x90, 0x88, 0x46, 0xee, 0xb8, 0x14, 0xde, 0x5e, 0x0b, 0xdb,
                                0xe0, 0x32, 0x3a, 0x0a, 0x49, 0x06, 0x24, 0x5c, 0xc2, 0xd3, 0xac, 0x62, 0x91, 0x95, 0xe4, 0x79,
                                0xe7, 0xc8, 0x37, 0x6d, 0x8d, 0xd5, 0x4e, 0xa9, 0x6c, 0x56, 0xf4, 0xea, 0x65, 0x7a, 0xae, 0x08,
                                0xba, 0x78, 0x25, 0x2e, 0x1c, 0xa6, 0xb4, 0xc6, 0xe8, 0xdd, 0x74, 0x1f, 0x4b, 0xbd, 0x8b, 0x8a,
                                0x70, 0x3e, 0xb5, 0x66, 0x48, 0x03, 0xf6, 0x0e, 0x61, 0x35, 0x57, 0xb9, 0x86, 0xc1, 0x1d, 0x9e,
                                0xe1, 0xf8, 0x98, 0x11, 0x69, 0xd9, 0x8e, 0x94, 0x9b, 0x1e, 0x87, 0xe9, 0xce, 0x55, 0x28, 0xdf,
                                0x8c, 0xa1, 0x89, 0x0d, 0xbf, 0xe6, 0x42, 0x68, 0x41, 0x99, 0x2d, 0x0f, 0xb0, 0x54, 0xbb, 0x16};


    static final int[] InvSBox = {0x52, 0x09, 0x6A, 0xD5, 0x30, 0x36, 0xA5, 0x38, 0xBF, 0x40, 0xA3, 0x9E, 0x81, 0xF3, 0xD7, 0xFB,
                                  0x7C, 0xE3, 0x39, 0x82, 0x9B, 0x2F, 0xFF, 0x87, 0x34, 0x8E, 0x43, 0x44, 0xC4, 0xDE, 0xE9, 0xCB,
                                  0x54, 0x7B, 0x94, 0x32, 0xA6, 0xC2, 0x23, 0x3D, 0xEE, 0x4C, 0x95, 0x0B, 0x42, 0xFA, 0xC3, 0x4E,
                                  0x08, 0x2E, 0xA1, 0x66, 0x28, 0xD9, 0x24, 0xB2, 0x76, 0x5B, 0xA2, 0x49, 0x6D, 0x8B, 0xD1, 0x25,
                                  0x72, 0xF8, 0xF6, 0x64, 0x86, 0x68, 0x98, 0x16, 0xD4, 0xA4, 0x5C, 0xCC, 0x5D, 0x65, 0xB6, 0x92,
                                  0x6C, 0x70, 0x48, 0x50, 0xFD, 0xED, 0xB9, 0xDA, 0x5E, 0x15, 0x46, 0x57, 0xA7, 0x8D, 0x9D, 0x84,
                                  0x90, 0xD8, 0xAB, 0x00, 0x8C, 0xBC, 0xD3, 0x0A, 0xF7, 0xE4, 0x58, 0x05, 0xB8, 0xB3, 0x45, 0x06,
                                  0xD0, 0x2C, 0x1E, 0x8F, 0xCA, 0x3F, 0x0F, 0x02, 0xC1, 0xAF, 0xBD, 0x03, 0x01, 0x13, 0x8A, 0x6B,
                                  0x3A, 0x91, 0x11, 0x41, 0x4F, 0x67, 0xDC, 0xEA, 0x97, 0xF2, 0xCF, 0xCE, 0xF0, 0xB4, 0xE6, 0x73,
                                  0x96, 0xAC, 0x74, 0x22, 0xE7, 0xAD, 0x35, 0x85, 0xE2, 0xF9, 0x37, 0xE8, 0x1C, 0x75, 0xDF, 0x6E,
                                  0x47, 0xF1, 0x1A, 0x71, 0x1D, 0x29, 0xC5, 0x89, 0x6F, 0xB7, 0x62, 0x0E, 0xAA, 0x18, 0xBE, 0x1B,
                                  0xFC, 0x56, 0x3E, 0x4B, 0xC6, 0xD2, 0x79, 0x20, 0x9A, 0xDB, 0xC0, 0xFE, 0x78, 0xCD, 0x5A, 0xF4,
                                  0x1F, 0xDD, 0xA8, 0x33, 0x88, 0x07, 0xC7, 0x31, 0xB1, 0x12, 0x10, 0x59, 0x27, 0x80, 0xEC, 0x5F,
                                  0x60, 0x51, 0x7F, 0xA9, 0x19, 0xB5, 0x4A, 0x0D, 0x2D, 0xE5, 0x7A, 0x9F, 0x93, 0xC9, 0x9C, 0xEF,
                                  0xA0, 0xE0, 0x3B, 0x4D, 0xAE, 0x2A, 0xF5, 0xB0, 0xC8, 0xEB, 0xBB, 0x3C, 0x83, 0x53, 0x99, 0x61,
                                  0x17, 0x2B, 0x04, 0x7E, 0xBA, 0x77, 0xD6, 0x26, 0xE1, 0x69, 0x14, 0x63, 0x55, 0x21, 0x0C, 0x7D};

    static final int[] RConstant = {0x00, 0x01, 0x02, 0x04, 0x08, 0x10, 0x20, 0x40, 0x80, 0x1B, 0x36};

    int Nk = 4;   // No Of Words In Each Key
    int Nr = 10;  // No Of Rounds
    int Nb = 4;   // No Of Bytes In Each Word

    private int [][] textToMatrix(String Text){
        int state [][] = new int [4][4];
        int length = Text.length();
        for (int counter = 0 ; counter < length / 2 ; counter++){
            int Byte = Integer.parseInt(Text.substring(2 * counter, 2 * counter + 2),16) ;
            state [counter / 4][counter % 4] = Byte;
        }
        return state;
    }

    private String matrixToText( int [][] Matrix){
        String text="";
        for (int counter = 0 ; counter < 4; counter++){
            for (int counter1 = 0 ; counter1 <4 ; counter1++){
                if(Integer.toHexString(Matrix[counter][counter1]).length() < 2)
                    text += "0";
                text += Integer.toHexString(Matrix[counter][counter1]);
            }
        }
        return text;
    }

    private int [][] subBytes(int [][]Matrix){
        for (int counter = 0 ; counter < Nb; counter++){
            for (int counter1 = 0 ; counter1 <4 ; counter1++){
                Matrix[counter][counter1] = SBox[Matrix[counter][counter1]];
            }
        }
        return Matrix;
    }

    private int [][] InvSubBytes(int [][]Matrix){
        for (int counter = 0 ; counter < Nb; counter++){
            for (int counter1 = 0 ; counter1 <4 ; counter1++){
                Matrix[counter][counter1] = InvSBox[Matrix[counter][counter1]];
            }
        }
        return Matrix;
    }

    private int [][] shiftRows(int [][]Matrix){
        int temp,temp1_1,temp1_2,temp2;
        temp = Matrix[0][1];
        temp1_1 = Matrix[1][2]; temp1_2 = Matrix[0][2];
        temp2 = Matrix[0][3];
        Matrix[0][1] = Matrix[1][1]; Matrix[1][1] = Matrix[2][1]; Matrix[2][1] = Matrix[3][1]; Matrix[3][1] = temp;
        Matrix[1][2] = Matrix[3][2]; Matrix[0][2] = Matrix[2][2]; Matrix[2][2] = temp1_2; Matrix[3][2] = temp1_1;
        Matrix[0][3] = Matrix[3][3]; Matrix[3][3] = Matrix[2][3]; Matrix[2][3] = Matrix[1][3]; Matrix[1][3] = temp2;
        return Matrix;
    }

    private int [][] InvShiftRows(int [][]Matrix){
        int temp,temp1_1,temp1_2,temp2;
        temp = Matrix[2][1];
        temp1_1 = Matrix[0][2]; temp1_2 = Matrix[1][2];
        temp2 = Matrix [0][3];
        Matrix[2][1] = Matrix[1][1]; Matrix[1][1] = Matrix[0][1]; Matrix[0][1] = Matrix[3][1]; Matrix[3][1] = temp;
        Matrix[0][2] = Matrix[2][2]; Matrix[2][2] = temp1_1; Matrix[1][2] = Matrix[3][2]; Matrix[3][2] = temp1_2;
        Matrix[0][3] = Matrix[1][3]; Matrix[1][3] = Matrix[2][3]; Matrix[2][3] = Matrix[3][3]; Matrix[3][3] = temp2;
        return Matrix;
    }

    private int xTime(int b){
        if ((b & 0x80) == 0x80){
            b = b << 1;
            b ^= 0x1B;
        }
        else
            b = b << 1;

        return b & 0xFF;
    }

    private int [] mixOneColumn(int c[]){
        int t = c[0] ^ c[1] ^ c[2] ^ c[3];
        int u = c[0];
        c[0] ^= xTime(c[0] ^ c[1]) ^ t;
        c[1] ^= xTime(c[1] ^ c[2]) ^ t;
        c[2] ^= xTime(c[2] ^ c[3]) ^ t;
        c[3] ^= xTime(c[3] ^ u) ^ t;
        return c;
    }

    private int [][] mixColumns(int s[][]){
        for (int counter = 0; counter < Nb; counter++){
            s[counter] = mixOneColumn(s[counter]);
        }
        return s;
    }

    private int [][] InvMixColumns( int s[][]){
        for (int counter = 0; counter < Nb; counter++){
            int u = xTime(xTime(s[counter][0] ^ s[counter][2]));
            int v = xTime(xTime(s[counter][1] ^ s[counter][3]));
            s[counter][0] ^= u;
            s[counter][1] ^= v;
            s[counter][2] ^= u;
            s[counter][3] ^= v;
        }
        mixColumns(s);
        return s;
    }

    private int [][] addRoundKey(int [][] s,int [][] k){
        for (int counter = 0; counter < Nb; counter++){
            for (int counter1 = 0; counter1 < Nb; counter1++){
                s[counter][counter1] ^= k[counter][counter1];
            }
        }
        return s;
    }

    private int [] subWord(int [] word){
        for (int counter = 0; counter < word.length; counter++){
            word[counter] = SBox[word[counter]];
        }
        return word;
    }

    private int [] rotateWord(int [] word){
        int temp = word[0];
        word[0] = word[1]; word[1] = word[2]; word[2] = word[3]; word[3] = temp;
        return word;
    }

    public int [][] keyExpansion (String key){
        List<List<Integer>> tempArray = new ArrayList<>();
        int [][] roundKeys = textToMatrix(key) ;

        for(int count = 0; count < roundKeys.length; count++){
            tempArray.add(new ArrayList<>());
            for(int count2 = 0; count2 < 4; count2++ ){
                tempArray.get(count).add(count2,roundKeys[count][count2]);
            }
        }

        for (int i = Nk; i < Nb * (Nr + 1); i++){
            tempArray.add(new ArrayList<>());
            for(int count = 0; count < 4; count++ ){
                tempArray.get(tempArray.size()-1).add(0);
            }
            int [] temp = new int[4];
            for(int count = 0; count < 4; count++ ){
                temp[count] = tempArray.get(i - 1).get(count);
            }
            if(i % Nk == 0){
                temp = rotateWord(temp);
                temp = subWord(temp);
                temp[0] = temp[0] ^ RConstant[i / Nk];
            }

            for (int j = 0; j < 4; j++){
                tempArray.get(i).set(j,tempArray.get(i - Nk).get(j) ^ temp[j]) ;
            }

        }

        roundKeys = new int[tempArray.size()][4];
        for(int count = 0; count < roundKeys.length; count++){
            for(int count2 = 0; count2 < 4; count2++ ){
                roundKeys[count][count2] = tempArray.get(count).get(count2);
            }
        }

        return roundKeys;
    }

    public String Encrypt(String text, int [][] roundKeys){
        int state [][] = textToMatrix(text);
        state = addRoundKey(state, roundKeys);

        for (int i = 1; i < Nr; i++){
            state = subBytes(state);
            state = shiftRows(state);
            state = mixColumns(state);

            int temp [][] = new int [4][4];
            int outerCounter = 0;
            for(int count = i * Nb; count < Nb * (i + 1); count++){
                for(int count2 = 0; count2 < 4; count2++ ){
                    temp[outerCounter][count2] = roundKeys[count][count2];
                }
                outerCounter++;
            }

            state = addRoundKey(state, temp);
        }

        int temp [][] = new int [4][4];
        for(int count = roundKeys.length - 4; count < roundKeys.length; count++){
            for(int count2 = 0; count2 < 4; count2++ ){
                temp[count - 40][count2] = roundKeys[count][count2];
            }
        }

        state = subBytes(state);
        state = shiftRows(state);
        state = addRoundKey(state, temp);

        return matrixToText(state);
    }

    public String Decrypt(String text, int [][] roundKeys){
        int state [][] = textToMatrix(text);
        int tempRoundKey[][] = new int[4][4];
        int outerCounter = 0;
        for(int i = roundKeys.length - 4; i < roundKeys.length; i++){
            for (int j = 0; j < 4; j++){
                tempRoundKey[outerCounter][j] = roundKeys[i][j];
            }
            outerCounter++;
        }
        state = addRoundKey(state, tempRoundKey);

        for (int i = Nr - 1; i > 0; i--){
            state = InvShiftRows(state);
            state = InvSubBytes(state);

            int temp [][] = new int [4][4];
            int outerCounter1 = 0;
            for(int count = i * Nb; count < Nb * (i + 1); count++){
                for(int count2 = 0; count2 < 4; count2++ ){
                    temp[outerCounter1][count2] = roundKeys[count][count2];
                }
                outerCounter1++;
            }

            state = addRoundKey(state, temp);
            state = InvMixColumns(state);
        }

        state = InvShiftRows(state);
        state = InvSubBytes(state);

        int temp [][] = new int [4][4];
        for(int count = 0; count < 4; count++){
            for(int count2 = 0; count2 < 4; count2++ ){
                temp[count][count2] = roundKeys[count][count2];
            }
        }

        state = addRoundKey(state, temp);

        return matrixToText(state);
    }
//    public static void main(String[] args) {
//        AES test = new AES();
//        String word = "0123456789ABCDEF0123456789ABCDEF";
//        String cipher;
//        int [][] keys = test.keyExpansion(word);
//        cipher = test.Encrypt(word,keys).toUpperCase(Locale.ROOT);
//        System.out.println("Cipher Text:\n"+cipher);
//        System.out.println("Decrypted Text :\n"+test.Decrypt(cipher,keys).toUpperCase(Locale.ROOT));
//    }
}
