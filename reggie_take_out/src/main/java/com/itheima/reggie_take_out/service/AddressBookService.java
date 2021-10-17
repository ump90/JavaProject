package com.itheima.reggie_take_out.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.itheima.reggie_take_out.common.CommonReturn;
import com.itheima.reggie_take_out.entity.AddressBook;

/**
 * @author UMP90
 * @date 2021/10/17
 */

public interface AddressBookService extends IService<AddressBook> {
    public CommonReturn<?> addAddressBook(AddressBook addressBook);
    public CommonReturn<?> listAddressBook();
    public CommonReturn<?> getDefaultAddress();
    public CommonReturn<?> setDefaultAddress(Long id);
    public CommonReturn<?> getAddressById(Long id);
    public CommonReturn<?> updateAddress(AddressBook addressBook);
}

