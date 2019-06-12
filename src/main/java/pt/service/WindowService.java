package pt.service;
import pt.domain.Window;

import java.util.Set;

public interface WindowService extends IService<Window, String>{
    Set<Window> getAll();
}
