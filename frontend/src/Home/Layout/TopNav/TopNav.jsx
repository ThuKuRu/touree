/* eslint-disable jsx-a11y/no-static-element-interactions */
import React, { useState } from "react";
import { TopNavStyle, Logo, MenuItem, Avatar, SelectList } from "./index.style";
import LogoImg from "../../../img/logo_2.png";
import AvatarImg from "../../../img/thu_1.png";
import { useNavigate } from "react-router-dom";
const TopNav = ({ tab, setTab }) => {
  const [value, setValue] = useState("en");

  const handleChange = (event) => {
    setValue(event.target.value);
  };
  const navigate = useNavigate();
  return (
    <TopNavStyle>
      <div className="appBar">
        <div className="toolbar">
          <div
            className="headLogo cursor-pointer"
            onClick={() => navigate("/")}
          >
            <Logo src={LogoImg} />
            <p>WORLD TRAVEL</p>
          </div>
          <div className="listItem">
            <div className={`container ${tab === "home" ? "active" : null}`}>
              <div
                onClick={() => {
                  navigate("/");
                }}
              >
                HOME
              </div>
            </div>
            <div className={`container ${tab === "tour" ? "active" : null}`}>
              <div
                onClick={() => {
                  navigate("/manage");
                }}
              >
                MANAGE
              </div>
            </div>
          </div>
          <div className="headRight">
            <SelectList value={value} onChange={handleChange}>
              <MenuItem value="en" selected="selected">
                ENGLISH(UK)
              </MenuItem>
              <MenuItem value="vi">VIETNAMESE</MenuItem>
            </SelectList>
            <Avatar src={AvatarImg} variant="rounded" />
          </div>
        </div>
      </div>
    </TopNavStyle>
  );
};

export default TopNav;
