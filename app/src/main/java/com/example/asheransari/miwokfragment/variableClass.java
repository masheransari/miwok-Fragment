package com.example.asheransari.miwokfragment;

/**
 * Created by asher.ansari on 9/30/2016.
 */
public class variableClass {
    private String mDefaulttranslate;
    private String mMiwokTranslation;
    private int mImageResourceID = NO_IMAGE_PROVIDE;
    private static final int NO_IMAGE_PROVIDE=-1;
    private int mAudioResourceID;

    public String getmMiwokTranslation() {
        return mMiwokTranslation;
    }

    public int getmAudioResourceID() {
        return mAudioResourceID;
    }

    public int getmImageResourceID() {
        return mImageResourceID;
    }

    public String getmDefaulttranslate() {
        return mDefaulttranslate;
    }
public boolean hasImage()
{
    return mImageResourceID != NO_IMAGE_PROVIDE;
}

    public variableClass(String Defaultranslation, String MiwokTranslation, int AudioResourceID){
        mDefaulttranslate = Defaultranslation;

        mMiwokTranslation = MiwokTranslation;
        mAudioResourceID = AudioResourceID;
    }
    public variableClass(String DefaultTranslation, String MiwokTranslation,int imageResource, int AudioResourceID)
    {
        mDefaulttranslate = DefaultTranslation;
        mMiwokTranslation = MiwokTranslation;
        mAudioResourceID = AudioResourceID;
        mImageResourceID = imageResource;
    }



}
