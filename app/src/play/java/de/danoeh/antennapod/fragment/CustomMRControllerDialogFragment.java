package de.danoeh.antennapodSA.fragment;

import android.content.Context;
import android.os.Bundle;
import androidx.mediarouter.app.MediaRouteControllerDialog;
import androidx.mediarouter.app.MediaRouteControllerDialogFragment;

import de.danoeh.antennapodSA.dialog.CustomMRControllerDialog;

public class CustomMRControllerDialogFragment extends MediaRouteControllerDialogFragment {
    @Override
    public MediaRouteControllerDialog onCreateControllerDialog(Context context, Bundle savedInstanceState) {
        return new CustomMRControllerDialog(context);
    }
}
