package ru.ifmo.zuul.generator.Bundles;

import io.dummymaker.bundle.impl.BasicBundle;

public class BundleTypes extends BasicBundle<String> {
    public BundleTypes() {
        super(
                "Штраф",
                "Лишение права заниматься определенной деятельностью",
                "Обязательные работы",
                "Исправительные работы",
                "Ограничение свободы",
                "Лишение свободы на определенный срок"
        );
    }
}
