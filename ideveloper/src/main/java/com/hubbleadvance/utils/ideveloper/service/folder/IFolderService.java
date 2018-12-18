package com.hubbleadvance.utils.ideveloper.service.folder;

import java.util.List;

import com.hubbleadvance.utils.ideveloper.domain.folder.Folder;

public interface IFolderService {
    List<Folder> listByProject(String proid);
    List<Folder> listByParent(String parid);
}
