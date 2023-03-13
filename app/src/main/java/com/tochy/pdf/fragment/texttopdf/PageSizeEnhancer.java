package com.tochy.pdf.fragment.texttopdf;

import android.content.Context;
import androidx.annotation.NonNull;

import com.tochy.pdf.R;
import com.tochy.pdf.interfaces.Enhancer;
import com.tochy.pdf.pdfModel.EnhancementOptionsEntity;
import com.tochy.pdf.pdfPreferences.TextToPdfPreferences;
import com.tochy.pdf.util.PageSizeUtils;

/**
 * An {@link Enhancer} that lets you select page size.
 */
public class PageSizeEnhancer implements Enhancer {

    private final PageSizeUtils mPageSizeUtils;
    private final EnhancementOptionsEntity mEnhancementOptionsEntity;

    PageSizeEnhancer(@NonNull final Context context) {
        mPageSizeUtils = new PageSizeUtils(context);
        mEnhancementOptionsEntity = new EnhancementOptionsEntity(
                context, R.drawable.ic_page_size_24dp, R.string.set_page_size_text);

        PageSizeUtils.mPageSize = new TextToPdfPreferences(context).getPageSize();
    }

    @Override
    public void enhance() {
        mPageSizeUtils.showPageSizeDialog(false);
    }

    @Override
    public EnhancementOptionsEntity getEnhancementOptionsEntity() {
        return mEnhancementOptionsEntity;
    }

}
