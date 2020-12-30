package com.ldd.consumer.core.transfer;

import com.ldd.consumer.core.model.PageData;
import org.springframework.util.CollectionUtils;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class VoTransfers {

  public static class ListVoTransfer<T, V> implements VoTransfer<List<T>, List<V>> {

    private VoTransfer<T, V> voTransfer;

    public ListVoTransfer(VoTransfer<T, V> voTransfer) {
      this.voTransfer = checkNotNull(voTransfer);
    }

    @Override
    public List<V> transfer2VO(List<T> tList) {
      if (CollectionUtils.isEmpty(tList)) {
        return Collections.emptyList();
      }

      return tList.stream().map(t -> voTransfer.transfer2VO(t)).collect(Collectors.toList());
    }
  }

  public static class MapVoTransfer<T, V>
      implements VoTransfer<Map<String, List<T>>, Map<String, List<V>>> {

    private ListVoTransfer<T, V> listVoTransfer;

    public MapVoTransfer(ListVoTransfer<T, V> listVoTransfer) {
      this.listVoTransfer = checkNotNull(listVoTransfer);
    }

    @Override
    public Map<String, List<V>> transfer2VO(Map<String, List<T>> objectListMap) {
      if (objectListMap == null) {
        return null;
      }
      Map<String, List<V>> resultMap = new HashMap<>();
      objectListMap.forEach((o, tList) -> resultMap.put(o, listVoTransfer.transfer2VO(tList)));
      return resultMap;
    }
  }

  public static class PageDataVoTransfer<T, V> implements VoTransfer<PageData<T>, PageData<V>> {

    private ListVoTransfer<T, V> listVoTransfer;

    public PageDataVoTransfer(ListVoTransfer<T, V> listVoTransfer) {
      this.listVoTransfer = checkNotNull(listVoTransfer);
    }

    @Override
    public PageData<V> transfer2VO(PageData<T> pageData) {
      if (pageData == null) {
        return null;
      }
      return PageData.of(listVoTransfer.transfer2VO(pageData.getData()), pageData.getTotalNum());
    }
  }


  private static <T> T checkNotNull(T reference) {
    if (reference == null) {
      throw new NullPointerException();
    } else {
      return reference;
    }
  }

}
